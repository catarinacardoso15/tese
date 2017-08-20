package classifier.attetion.domain;

public class Mouse {
    private double mv;
    private double ma;
    private double cd;
    private double tbc;
    private double dbc;
    private double ddc;
    private double edbc;
    private double aedbc;
    private double ssdbc;
    private double asdbc;
    private double tdc;
    private double dplbc;
    private double adpbc;
    private long timestamp;

    public Mouse() {
    }

    public Mouse(double mv, double ma, double cd,
                 double tbc, double dbc, double ddc,
                 double edbc, double aedbc, double ssdbc,
                 double asdbc, double tdc, double dplbc,
                 double adpbc, long timestamp) {
        this.mv = mv;
        this.ma = ma;
        this.cd = cd;
        this.tbc = tbc;
        this.dbc = dbc;
        this.ddc = ddc;
        this.edbc = edbc;
        this.aedbc = aedbc;
        this.ssdbc = ssdbc;
        this.asdbc = asdbc;
        this.tdc = tdc;
        this.dplbc = dplbc;
        this.adpbc = adpbc;
        this.timestamp = timestamp;
    }

    public double getMv() {
        return mv;
    }

    public void setMv(double mv) {
        this.mv = mv;
    }

    public double getMa() {
        return ma;
    }

    public void setMa(double ma) {
        this.ma = ma;
    }

    public double getCd() {
        return cd;
    }

    public void setCd(double cd) {
        this.cd = cd;
    }

    public double getTbc() {
        return tbc;
    }

    public void setTbc(double tbc) {
        this.tbc = tbc;
    }

    public double getDbc() {
        return dbc;
    }

    public void setDbc(double dbc) {
        this.dbc = dbc;
    }

    public double getDdc() {
        return ddc;
    }

    public void setDdc(double ddc) {
        this.ddc = ddc;
    }

    public double getEdbc() {
        return edbc;
    }

    public void setEdbc(double edbc) {
        this.edbc = edbc;
    }

    public double getAedbc() {
        return aedbc;
    }

    public void setAedbc(double aedbc) {
        this.aedbc = aedbc;
    }

    public double getSsdbc() {
        return ssdbc;
    }

    public void setSsdbc(double ssdbc) {
        this.ssdbc = ssdbc;
    }

    public double getAsdbc() {
        return asdbc;
    }

    public void setAsdbc(double asdbc) {
        this.asdbc = asdbc;
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

    public double getAdpbc() {
        return adpbc;
    }

    public void setAdpbc(double adpbc) {
        this.adpbc = adpbc;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
