package classifier.models;

public class User {
    private int id;
    private String identifier;
    private float attentionScore;
    private int learningStyle;

    public User(int id, String identifier, float attentionScore, int learningStyle) {
        this.id = id;
        this.identifier = identifier;
        this.attentionScore = attentionScore;
        this.learningStyle = learningStyle;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public float getAttentionScore() {
        return attentionScore;
    }

    public void setAttentionScore(float attentionScore) {
        this.attentionScore = attentionScore;
    }

    public int getLearningStyle() {
        return learningStyle;
    }

    public void setLearningStyle(int learningStyle) {
        this.learningStyle = learningStyle;
    }
}
