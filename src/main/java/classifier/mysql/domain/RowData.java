package classifier.mysql.domain;

import javax.persistence.*;

@Entity
public class RowData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private Measures measure;

    private float mv;
    private float ma;
    private float cd;
    private float tbc;
    private float dbc;
    private float ddc;
    private float tdc;
    private float dplbc;
    private float kdt;
    private float tbk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Measures getMeasure() {
        return measure;
    }

    public void setMeasure(Measures measure) {
        this.measure = measure;
    }

    public float getMv() {
        return mv;
    }

    public void setMv(float mv) {
        this.mv = mv;
    }

    public float getMa() {
        return ma;
    }

    public void setMa(float ma) {
        this.ma = ma;
    }

    public float getCd() {
        return cd;
    }

    public void setCd(float cd) {
        this.cd = cd;
    }

    public float getTbc() {
        return tbc;
    }

    public void setTbc(float tbc) {
        this.tbc = tbc;
    }

    public float getDbc() {
        return dbc;
    }

    public void setDbc(float dbc) {
        this.dbc = dbc;
    }

    public float getDdc() {
        return ddc;
    }

    public void setDdc(float ddc) {
        this.ddc = ddc;
    }

    public float getTdc() {
        return tdc;
    }

    public void setTdc(float tdc) {
        this.tdc = tdc;
    }

    public float getDplbc() {
        return dplbc;
    }

    public void setDplbc(float dplbc) {
        this.dplbc = dplbc;
    }

    public float getKdt() {
        return kdt;
    }

    public void setKdt(float kdt) {
        this.kdt = kdt;
    }

    public float getTbk() {
        return tbk;
    }

    public void setTbk(float tbk) {
        this.tbk = tbk;
    }
}
