package classifier.attetion.domain;

public class MouseResults {
    private double ma;
    private double mv;
    private double tbc;
    private double tdc;
    private double dplbc;
    private double ddc;
    private double dbc;
    private double cd;

    public MouseResults() {
    }

    public MouseResults(double ma, double mv, double tbc, double tdc, double dplbc, double ddc, double dbc, double cd) {
        this.ma = ma;
        this.mv = mv;
        this.tbc = tbc;
        this.tdc = tdc;
        this.dplbc = dplbc;
        this.ddc = ddc;
        this.dbc = dbc;
        this.cd = cd;
    }

    public double getMa() {
        return ma;
    }

    public void setMa(double ma) {
        this.ma = ma;
    }

    public double getMv() {
        return mv;
    }

    public void setMv(double mv) {
        this.mv = mv;
    }

    public double getTbc() {
        return tbc;
    }

    public void setTbc(double tbc) {
        this.tbc = tbc;
    }

    public double getTdc() {
        return tdc;
    }

    public void setTdc(double tdc) {
        this.tdc = tdc;
    }

    public double getDplbc() {
        return dplbc;
    }

    public void setDplbc(double dplbc) {
        this.dplbc = dplbc;
    }

    public double getDdc() {
        return ddc;
    }

    public void setDdc(double ddc) {
        this.ddc = ddc;
    }

    public double getDbc() {
        return dbc;
    }

    public void setDbc(double dbc) {
        this.dbc = dbc;
    }

    public double getCd() {
        return cd;
    }

    public void setCd(double cd) {
        this.cd = cd;
    }
}
