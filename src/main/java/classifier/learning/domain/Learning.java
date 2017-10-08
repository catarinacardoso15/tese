package classifier.learning.domain;

public class Learning {
    private int typeClass;
    private double evaluation;
    private double attention;

    public Learning() {
    }

    public Learning(int typeClass, double evaluation, double attention) {
        this.typeClass = typeClass;
        this.evaluation = evaluation;
        this.attention = attention;
    }

    public int getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(int typeClass) {
        this.typeClass = typeClass;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }

    public double getAttention() {
        return attention;
    }

    public void setAttention(double attention) {
        this.attention = attention;
    }
}
