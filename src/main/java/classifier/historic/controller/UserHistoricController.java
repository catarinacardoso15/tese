package classifier.historic.controller;

import classifier.MySQLDTO;
import classifier.historic.domain.UserHistoric;
import classifier.models.User;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
public class UserHistoricController {

    @RequestMapping(method = RequestMethod.POST, path = "/historic/geral")
    public UserHistoric sendResults(@RequestParam("user") String user) throws ParseException, SQLException {
        MySQLDTO dto = new MySQLDTO();
        User u = dto.getUser(user);
        UserHistoric userh = new UserHistoric();
        userh.setIdentifier(u.getIdentifier());
        userh.setAttention(u.getAttentionScore());
        return userh;
    }
}
