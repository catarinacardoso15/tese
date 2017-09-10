package classifier.learning.controller;

import classifier.mysql.controller.SessionController;
import classifier.mysql.controller.UserController;
import classifier.mysql.domain.Session;
import classifier.mysql.domain.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestController {

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
        for(Map.Entry<String,Integer> entry : evaluations.entrySet()){
            Session s = sc.getSessionByTokenByUser(token,entry.getKey());
            if(s!=null){
                s.setScore(entry.getValue());
                sc.save(s);
            }
        }
        return true;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/learning")
    public int getLearning(@RequestParam("Identifier")String user){
        UserController uc = new UserController();
        User u = uc.findByIdentifier(user);
        //se nao tiver inserido fazer o algoritmo novamente
        return u.getLearningStyle();
    }
}