package classifier.mysql.controller;

import classifier.mysql.domain.Session;
import classifier.mysql.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    public Session save(Session s){
        return sessionRepository.save(s);
    }

    public Session getSession(long id){
        return sessionRepository.findOne(id);
    }

    public Session getSessionByToken(String token){
        return sessionRepository.findByToken(token);
    }

    public ArrayList<Session> getAllSessionsByUser(long id){
        return sessionRepository.findAllByUserId(id);
    }

    public Session updateDate(long id, long finalDate){
        Session s = sessionRepository.findOne(id);
        s.setTimestampFinal(finalDate);
        return sessionRepository.save(s);
    }

    public Session updateScore(String token, int score){
       Session s = sessionRepository.findByToken(token);
       s.setScore(score);
       return sessionRepository.save(s);
    }
    public Session getSessionByTokenByUser(String token, String user){
        return sessionRepository.findByTokenAndAndUserIdentifier(token,user);
    }
}
