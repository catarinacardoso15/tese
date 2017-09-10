package classifier.historic.controller;


import classifier.historic.domain.Day;
import classifier.historic.domain.UserHistoricDays;
import classifier.mysql.controller.MeasuresController;
import classifier.mysql.controller.SessionController;
import classifier.mysql.controller.UserController;
import classifier.mysql.domain.Session;
import classifier.mysql.domain.User;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.*;

@RestController
public class UserHistoricController {

    @RequestMapping(method = RequestMethod.GET, path = "/historic/global")
    public float sendResultsGloabl(@RequestParam("identifier") String user) throws ParseException, SQLException {
        UserController uc = new UserController();
        User u = uc.findByIdentifier(user);
        return u.getAttetionTotalScore()/u.getMeasuresCount();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/historic/days")
    public UserHistoricDays sendResultsDays(@RequestParam("identifier") String user) throws ParseException, SQLException {
        UserController uc = new UserController();
        SessionController sc = new SessionController();
        User u = uc.findByIdentifier(user);
        ArrayList<Session> listSession = sc.getAllSessionsByUser(u.getId());
        TreeMap<Date,ArrayList<Session>> results = getResultsWithoutTime(listSession);
        UserHistoricDays historic = new UserHistoricDays();
        historic.setUser(user);
        ArrayList<Day> listDays = new ArrayList<Day>();
        for(Map.Entry<Date,ArrayList<Session>> entry : results.entrySet()){
            Day d = new Day();
            d.setTimestamp(entry.getKey().getTime());
            float value =0;
            MeasuresController mc = new MeasuresController();
            for(Session session :entry.getValue()) {
               value = value + mc.getAvgAttetion(session.getId());
            }
            d.setAttention((double) value);
            listDays.add(d);
        }
        historic.setDays(listDays);
        historic.setTotalAttention(u.getAttetionTotalScore()/u.getMeasuresCount());
        return historic;
    }

    private TreeMap<Date,ArrayList<Session>> getResultsWithoutTime(ArrayList<Session> listSession){
        TreeMap<Date,ArrayList<Session>> mapResults = new TreeMap<Date,ArrayList<Session>>();
        listSession.forEach(session -> {
            Date sessionDate = new Date(session.getTimestampFinal());
            sessionDate.setMinutes(0);
            sessionDate.setHours(0);
            sessionDate.setSeconds(0);
            ArrayList<Session> s = new ArrayList<Session>();

            if(mapResults.containsKey(sessionDate)){
                s = mapResults.get(sessionDate);
            }
            s.add(session);
            mapResults.put(sessionDate,s);
        });

        return mapResults;
    }


}
