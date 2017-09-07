package classifier.mysql.controller;

import classifier.mysql.domain.RowData;
import classifier.mysql.repository.RowDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RowDataController {

    @Autowired
    private RowDataRepository rowDataRepository;

    public RowData getRowData(long id){
        return rowDataRepository.findOne(id);
    }

    public RowData getRowDataByMeasure(long idMeasure){
        return rowDataRepository.findByMeasure_Id(idMeasure);
    }

    public boolean save(RowData rd){
        rowDataRepository.save(rd);
        return true;
    }
}
