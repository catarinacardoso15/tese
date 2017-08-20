package classifier.attetion.domain;

public class KeyboardResults {

    private double kdt;
    private double tbk;

    public KeyboardResults() {
    }

    public KeyboardResults(double kdt, double tbk) {
        this.kdt = kdt;
        this.tbk = tbk;
    }

    public double getKdt() {
        return kdt;
    }

    public void setKdt(double kdt) {
        this.kdt = kdt;
    }

    public double getTbk() {
        return tbk;
    }

    public void setTbk(double tbk) {
        this.tbk = tbk;
    }
}
