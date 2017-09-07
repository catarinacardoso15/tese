package classifier.historic.domain;

public class UserHistoricGlobal {
    private String identifier;
    private float attention;

    public UserHistoricGlobal(String identifier, float attention) {
        this.identifier = identifier;
        this.attention = attention;
    }

    public UserHistoricGlobal() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public float getAttention() {
        return attention;
    }

    public void setAttention(float attention) {
        this.attention = attention;
    }
}
