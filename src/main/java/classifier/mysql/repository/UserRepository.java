package classifier.mysql.repository;


import classifier.mysql.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

    User findByIdentifier(String identifier);
    User getByIdentifier(String identifier);
    User getUserByIdentifier(String identifier);
}
