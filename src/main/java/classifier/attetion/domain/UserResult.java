package classifier.attetion.domain;

public class UserResult {
    private String user;
    private float attention;
    private float usefulTime;
    private float time;
    private RowData rowData;

    public UserResult() {
    }

    public UserResult(String user, float attention, float usefulTime, float time) {
        this.user = user;
        this.attention = attention;
        this.usefulTime = usefulTime;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getAttention() {
        return attention;
    }

    public void setAttention(float attention) {
        this.attention = attention;
    }

    public float getUsefulTime() {
        return usefulTime;
    }

    public void setUsefulTime(float usefulTime) {
        this.usefulTime = usefulTime;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public RowData getRowData() {
        return rowData;
    }

    public void setRowData(RowData rowData) {
        this.rowData = rowData;
    }
}
