package classifier.historic.domain;

public class Day {
    private long timestamp;
    private double attention;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getAttention() {
        return attention;
    }

    public void setAttention(double attention) {
        this.attention = attention;
    }
}
