package classifier.attetion.domain;

public class Keyboard {
    private long timestamp;
    private double kdt;
    private double tbk;

    public Keyboard() {
    }

    public Keyboard(long timestamp, double ktd, double tbk) {
        this.timestamp = timestamp;
        this.kdt = ktd;
        this.tbk = tbk;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getKdt() {
        return kdt;
    }

    public double getTbk() {
        return tbk;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setKdt(double ktd) {
        this.kdt = ktd;
    }

    public void setTbk(double tbk) {
        this.tbk = tbk;
    }

}
