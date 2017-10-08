package classifier.mysql.controller;

import classifier.mysql.domain.Measures;
import classifier.mysql.repository.MeasuresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class MeasuresController {


    public Measures save(MeasuresRepository measuresRepository,Measures m){
        return measuresRepository.save(m);
    }

    public Measures getMeasureBySession(MeasuresRepository measuresRepository,long id){
        return measuresRepository.findBySessionId(id);
    }

    public ArrayList<Measures> getAllMeasuresBySession(MeasuresRepository measuresRepository,long id){
        return measuresRepository.findAllBySessionId(id);
    }

    public ArrayList<Measures> getAllMeasuresBetweenTime(MeasuresRepository measuresRepository,long time1, long time2){
        return measuresRepository.findAllByTimeBetween(time1,time2);
    }
    public float getAvgAttetion(MeasuresRepository measuresRepository,long id){
        return measuresRepository.getAvg(id);
    }
}
