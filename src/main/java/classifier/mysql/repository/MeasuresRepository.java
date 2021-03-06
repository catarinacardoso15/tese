package classifier.mysql.repository;

import classifier.mysql.domain.Measures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MeasuresRepository extends CrudRepository<Measures,Long> {

    public Measures findBySessionId(long id);

    public ArrayList<Measures> findAllByTimeBetween(long time1, long time2);

    public ArrayList<Measures> findAllBySessionId(long id);

    @Query("SELECT AVG(attention) FROM Measures WHERE session = :id")
    public float getAvg(long id);

}
