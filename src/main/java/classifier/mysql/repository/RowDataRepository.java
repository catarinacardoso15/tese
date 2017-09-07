package classifier.mysql.repository;

import classifier.mysql.domain.RowData;
import org.springframework.data.repository.CrudRepository;

public interface RowDataRepository extends CrudRepository<RowData,Long> {
    public RowData findByMeasure_Id(long id);

}
