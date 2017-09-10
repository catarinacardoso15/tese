package classifier.attetion.controller;

import classifier.MySQLDTO;
import classifier.attetion.domain.*;
import classifier.mysql.controller.MeasuresController;
import classifier.mysql.controller.RowDataController;
import classifier.mysql.controller.SessionController;
import classifier.mysql.controller.UserController;
import classifier.mysql.domain.Measures;
import classifier.mysql.domain.RowData;
import classifier.mysql.domain.Session;
import classifier.mysql.domain.User;
import com.mongodb.util.JSON;
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

@RestController
public class GeralResultsController {

    private ArrayList<String> listPeoples;
    private ArrayList<Rules> listRules;
    private String token;
    private int typeTask;

    public ArrayList<String> getListPeoples() {
        return listPeoples;
    }

    public void setListPeoples(ArrayList<String> listPeoples) {
        this.listPeoples = listPeoples;
    }

    public ArrayList<Rules> getListRules() {
        return listRules;
    }

    public void setListRules(ArrayList<Rules> listRules) {
        this.listRules = listRules;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(int typeTask) {
        this.typeTask = typeTask;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/classifier")
    public ArrayList<UserResult> sendResults(@RequestParam("DataInicial") String di, @RequestParam("DataFinal") String df, @RequestParam("Json") String json) throws ParseException, SQLException {
        Data d = getData(di,df);
        Date i = new Date(Long.parseLong(di));
        Date f = new Date(Long.parseLong(df));
        //ArrayList<UserData> listData = new ArrayList<UserData>();
        ArrayList<UserResult> listResults = new ArrayList<UserResult>();
        d.getUsersResult().forEach(userData -> {
            if(checkUser(listPeoples,userData.getUser())) {
               UserResult u = getAttentionResult(userData,f,listRules);
               listResults.add(u);
            }
        });

        listResults.forEach(userResult -> {
            saveDatabase(userResult,i,f);
        });

        return listResults;
    }

    private Data getData(String di, String df) {
        DataController controller = new DataController();
        Date i = new Date(Long.parseLong(di));
        Date f = new Date(Long.parseLong(df));
        return controller.createData(i, f);
    }

    public UserResult getAttentionResult(UserData u, Date finalDate, ArrayList<Rules> rules) {
        UserResultController controller = new UserResultController();
        return controller.getUser(u, finalDate, rules);
    }


    private boolean checkUser(ArrayList<String> list, String user) {
        boolean check = false;
        for (String u : list) {
            if (u.equals(user)) {
                check = true;
            }
        }
        return true;
    }

    private void getParameters(String json) throws ParseException {
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(json);
        JSONArray peoples = (JSONArray) obj.get("Peoples");
        setToken((String) obj.get("Token"));
        //setTypeTask((int) obj.get("Type"));

        JSONArray rules = (JSONArray) obj.get("Rules");
        setListPeoples(new ArrayList<String>());
        peoples.forEach(o -> listPeoples.add((String)o));

        setListRules(new ArrayList<Rules>());
        rules.forEach(o ->{
            JSONObject object = (JSONObject) o;
            Rules r = new Rules();
            r.setRegex((int)object.get("Regex"));
            r.setName((String)object.get("Name"));
            listRules.add(r);
        });
    }

    private void saveDatabase(UserResult userResult,Date i, Date f){
        UserController controller = new UserController();
        SessionController sessionc= new SessionController();
        User u=controller.findByIdentifier(userResult.getUser());
        if(u == null){
            u = controller.addUser(userResult.getUser());
        }
        Session s = sessionc.getSessionByToken(token);
        if(s == null){
            s.setUser(u);
            s.setToken(token);
            s.setTimestampStart(i.getTime());
            s.setTimestampFinal(f.getTime());

        }else{
            s.setTimestampFinal(f.getTime());
        }
        s = sessionc.save(s);
        MeasuresController mc = new MeasuresController();
        Measures m = new Measures();
        m.setSession(s);
        m.setAttention(userResult.getAttention());
        m.setTime(userResult.getTime());
        long time = f.getTime() - i.getTime();
        m.setTimestamp(i.getTime()+time);
        m.setUsefulTime(userResult.getUsefulTime());
        m = mc.save(m);
        RowDataController rdc = new RowDataController();
        RowData rw = new RowData();
        rw.setMa((float)userResult.getRowData().getMouse().getMa());
        rw.setMv((float)userResult.getRowData().getMouse().getMv());
        rw.setCd((float)userResult.getRowData().getMouse().getCd());
        rw.setDbc((float)userResult.getRowData().getMouse().getDbc());
        rw.setDdc((float)userResult.getRowData().getMouse().getDdc());
        rw.setDplbc((float) userResult.getRowData().getMouse().getDplbc());
        rw.setTbc((float)userResult.getRowData().getMouse().getTbc());
        rw.setTdc((float)userResult.getRowData().getMouse().getTdc());
        rw.setKdt((float)userResult.getRowData().getKeyboard().getKdt());
        rw.setTbk((float)userResult.getRowData().getKeyboard().getTbk());
        rw.setMeasure(m);
        rdc.save(rw);
    }
}
