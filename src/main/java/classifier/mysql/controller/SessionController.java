package classifier.mysql.controller;

import classifier.mysql.domain.Session;
import classifier.mysql.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class SessionController {



    public Session save(SessionRepository sessionRepository,Session s){
        return sessionRepository.save(s);
    }

    public Session getSession(SessionRepository sessionRepository, long id){
        return sessionRepository.findOne(id);
    }

    public Session getSessionByToken(SessionRepository sessionRepository,String token){
        return sessionRepository.findByToken(token);
    }

    public ArrayList<Session> getAllSessionsByUser(SessionRepository sessionRepository,long id){
        return sessionRepository.findAllByUserId(id);
    }

    public Session updateDate(SessionRepository sessionRepository, long id, long finalDate){
        Session s = sessionRepository.findOne(id);
        s.setTimestampFinal(finalDate);
        return sessionRepository.save(s);
    }

    public Session updateScore(SessionRepository sessionRepository, String token, int score){
       Session s = sessionRepository.findByToken(token);
       s.setScore(score);
       return sessionRepository.save(s);
    }
    public Session getSessionByTokenByUser(SessionRepository sessionRepository,String token, String user){
        return sessionRepository.findByTokenAndAndUserIdentifier(token,user);
    }
}
