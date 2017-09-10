package classifier.mysql.controller;

import classifier.mysql.domain.Measures;
import classifier.mysql.repository.MeasuresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class MeasuresController {

    @Autowired
    private MeasuresRepository measuresRepository;

    public Measures save(Measures m){
        return measuresRepository.save(m);
    }

    public Measures getMeasureBySession(long id){
        return measuresRepository.findBySessionId(id);
    }

    public ArrayList<Measures> getAllMeasuresBySession(long id){
        return measuresRepository.findAllBySessionId(id);
    }

    public ArrayList<Measures> getAllMeasuresBetweenTime(long time1, long time2){
        return measuresRepository.findAllByTimeBetween(time1,time2);
    }
    public float getAvgAttetion(long id){
        return measuresRepository.getAvg(id);
    }
}
