package classifier.mysql.controller;

import classifier.mysql.domain.RowData;
import classifier.mysql.repository.RowDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RowDataController {


    public RowData getRowData(RowDataRepository rowDataRepository,long id){
        return rowDataRepository.findOne(id);
    }

    public RowData getRowDataByMeasure(RowDataRepository rowDataRepository,long idMeasure){
        return rowDataRepository.findByMeasure_Id(idMeasure);
    }

    public boolean save(RowDataRepository rowDataRepository,RowData rd){
        rowDataRepository.save(rd);
        return true;
    }
}
