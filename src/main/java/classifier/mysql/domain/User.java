package classifier.mysql.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String identifier;
    private float attetionTotalScore;
    private Integer measuresCount;
    private Integer learningStyle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public float getAttetionTotalScore() {
        return attetionTotalScore;
    }

    public void setAttetionTotalScore(float attetionTotalScore) {
        this.attetionTotalScore = attetionTotalScore;
    }

    public Integer getMeasuresCount() {
        return measuresCount;
    }

    public void setMeasuresCount(Integer measuresCount) {
        this.measuresCount = measuresCount;
    }

    public Integer getLearningStyle() {
        return learningStyle;
    }

    public void setLearningStyle(Integer learningStyle) {
        this.learningStyle = learningStyle;
    }
}
