package classifier.attetion.domain;

import java.util.ArrayList;

public class GeralResults {
    private float attention;
    private float usefulTime;
    private float time;
    private ArrayList<UserResult> users;

    public GeralResults() {
    }

    public GeralResults(float attention, float usefulTime, float time, ArrayList<UserResult> users) {
        this.attention = attention;
        this.usefulTime = usefulTime;
        this.time = time;
        this.users = users;
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

    public ArrayList<UserResult> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserResult> users) {
        this.users = users;
    }
}
