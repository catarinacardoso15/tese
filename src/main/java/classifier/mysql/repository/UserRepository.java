package classifier.mysql.repository;


import classifier.mysql.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

    public User findByIdentifier(String identifier);
}
