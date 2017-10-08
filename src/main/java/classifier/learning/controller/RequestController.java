package classifier.learning.controller;

import classifier.learning.domain.Learning;
import classifier.mysql.controller.MeasuresController;
import classifier.mysql.controller.SessionController;
import classifier.mysql.controller.UserController;
import classifier.mysql.domain.Measures;
import classifier.mysql.domain.Session;
import classifier.mysql.domain.User;
import classifier.mysql.repository.MeasuresRepository;
import classifier.mysql.repository.SessionRepository;
import classifier.mysql.repository.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private MeasuresRepository measuresRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/evaluation")
    public boolean getEvaluation(@RequestParam("token") String token, @RequestParam("evaluation")String evaluation) throws ParseException, SQLException {
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(evaluation);
        JSONArray evaluationPeople = (JSONArray) obj.get("Peoples");

        HashMap<String, Integer> evaluations = new HashMap<>();
        evaluationPeople.forEach(o -> {
            JSONObject object = (JSONObject) o;
            evaluations.put((String) object.get("Identifier"),(Integer)object.get("Evaluation"));
        });
        SessionController sc = new SessionController();
        MeasuresController mc = new MeasuresController();
        for(Map.Entry<String,Integer> entry : evaluations.entrySet()){
            Session s = sc.getSessionByTokenByUser(sessionRepository,token,entry.getKey());
            Float attention = mc.getAvgAttetion(measuresRepository,s.getId());
            if(s!=null){
                s.setScore(entry.getValue());
                s.setAttentionSession(attention);
                sc.save(sessionRepository,s);
            }
        }
        return true;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/learning")
    public int getLearning(@RequestParam("Identifier")String user){
        SessionController sc = new SessionController();
        UserController uc = new UserController();
        User us = uc.findByIdentifier(userRepository,user);
        ArrayList<Session> list = sc.getAllSessionsByUser(sessionRepository,us.getId());
        if(list.isEmpty()){
            return -1;
        }
        try {
            Instances result = kmeansAlgorithm(datasetCreation(list));
            int learning = learningStyle(getResults(result));
            if(learning != -1){
                us.setLearningStyle(learning);
                uc.updateUser(userRepository,us);
                return learning;
            }else{
                return -1;
            }
        }catch (Exception e){
            return -1;
        }
    }

    private ArrayList<Learning> getResults(Instances res){
        ArrayList<Learning> learningResults = new ArrayList<>();
        for(Instance r: res){
            Learning l = new Learning();
            l.setAttention(r.value(1));
            l.setEvaluation(r.value(2));
            l.setTypeClass(((int) r.value(0)));
            learningResults.add(l);
        }
        return learningResults;
    }

    private Instances kmeansAlgorithm(Instances dataset){
        SimpleKMeans algorithm = new SimpleKMeans();
        try {
            algorithm.setNumClusters(4);
            algorithm.buildClusterer(dataset);
            return algorithm.getClusterCentroids();
        }catch (Exception w){
            System.out.println(w);
            return null;
        }
    }

    private Instances datasetCreation(ArrayList<Session> sessions){
        ArrayList<Attribute> atributes = new ArrayList<Attribute>();
        ArrayList<String> taskType = new ArrayList<String>();
        taskType.add("Video");
        taskType.add("Text");
        taskType.add("Image");
        taskType.add("Audio");

        Attribute a = new Attribute("task",taskType);
        Attribute b = new Attribute("attention");
        Attribute c = new Attribute("evaluation");
        atributes.add(a);
        atributes.add(b);
        atributes.add(c);
        Instances dataset = new Instances("Learning Style",atributes,0);

        for(Session s : sessions){
            double [] instance = new double[dataset.numAttributes()];
            instance[0]=s.getType();
            instance[1]=s.getAttentionSession();
            instance[2]=s.getScore();

            dataset.add(new DenseInstance(1.0,instance));
        }
        return dataset;
    }

    private int learningStyle(ArrayList<Learning>list){
        double best = 0;
        int typeTask = -1;

        for(Learning l : list){
            double evaluation = (100*l.getAttention())/10;
            double value = (evaluation*0.5)+(l.getAttention()*0.5);
            if(value > best){
                typeTask = l.getTypeClass();
            }

        }
        return typeTask;
    }
}