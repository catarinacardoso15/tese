package classifier.attetion.controller;

import classifier.MySQLDTO;
import classifier.attetion.domain.*;
import classifier.models.User;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
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

    @RequestMapping(method = RequestMethod.POST, path = "/classifier")
    public User sendResults(@RequestParam("DataInicial") String di, @RequestParam("DataFinal") String df, @RequestParam("Json") String rules) throws ParseException, SQLException {
        /*UserResult user1 = new UserResult("T222", 4, 4, 5);
        UserResult user2 = new UserResult("T223", 3, 6, 4);
        ArrayList<UserResult> list = new ArrayList<UserResult>();
        list.add(user1);
        list.add(user2);

        JSONObject r = new JSONObject();
        try {
            r = (JSONObject) parser.parse(rules);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }*/
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        MySQLDTO mysql = new MySQLDTO();
       UserResult n = new UserResult();
        n.setUser("test");
        n.setAttention(11);
        mysql.insertUser("ss");
        User u = mysql.getUser("teste1");

        return u;
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
}
