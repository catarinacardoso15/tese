package classifier.historic.controller;


import classifier.historic.domain.UserHistoricGlobal;
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
import java.util.ArrayList;
import java.util.Date;

@RestController
public class UserHistoricController {

    @RequestMapping(method = RequestMethod.GET, path = "/historic/global")
    public UserHistoricGlobal sendResultsGloabl(@RequestParam("identifier") String user) throws ParseException, SQLException {
        UserController uc = new UserController();
        User u = uc.findByIdentifier(user);
        UserHistoricGlobal userh = new UserHistoricGlobal();
        userh.setIdentifier(u.getIdentifier());
        userh.setAttention(u.getAttetionTotalScore()/u.getAttetionTotalScore());
        return userh;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/historic/days")
    public UserHistoricGlobal sendResultsDays(@RequestParam("identifier") String user) throws ParseException, SQLException {
        UserController uc = new UserController();
        SessionController sc = new SessionController();
        User u = uc.findByIdentifier(user);
        ArrayList<Session> listSession = sc.getAllSessionsByUser(u.getId());

        Date data = new Date();
        UserHistoricGlobal userh = new UserHistoricGlobal();
        userh.setIdentifier(u.getIdentifier());
        userh.setAttention(u.getAttetionTotalScore()/u.getAttetionTotalScore());
        return userh;
    }


}
