package classifier.mysql.repository;

import classifier.mysql.domain.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface SessionRepository extends CrudRepository<Session,Long> {
    public Session findByToken(String token);

    public ArrayList<Session> findAllByUserId(long id);

}
