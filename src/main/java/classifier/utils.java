package classifier;

import classifier.attetion.domain.Rules;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class utils {

    public ArrayList<Rules> getRules(String json) {
        JSONParser parser = new JSONParser();
        JSONObject r = new JSONObject();
        try {
            r = (JSONObject) parser.parse(json);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        JSONArray arr = (JSONArray) r.get("Rules");
        ArrayList<Rules> rules = new ArrayList<Rules>();
        arr.forEach(o -> {
            JSONObject v = (JSONObject) o;
            Rules rule = new Rules();
            rule.setName((String) v.get("Name"));
            rule.setRegex((int) v.get("Regex"));
            rules.add(rule);
        });
        return rules;
    }

    public ArrayList<String> getUsers(String json) {
        JSONParser parser = new JSONParser();
        JSONObject r = new JSONObject();
        try {
            r = (JSONObject) parser.parse(json);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        JSONArray arr = (JSONArray) r.get("Peoples");
        ArrayList<String> users = new ArrayList<String>();
        arr.forEach(o -> {
            JSONObject v = (JSONObject) o;
            users.add((String) v.get("Identifier"));
        });
        return users;
    }

    public String getToken(String json) {
        JSONParser parser = new JSONParser();
        JSONObject r = new JSONObject();
        try {
            r = (JSONObject) parser.parse(json);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return (String) r.get("Token");
    }
}
