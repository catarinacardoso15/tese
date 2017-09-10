package classifier.historic.domain;

import java.util.ArrayList;

public class UserHistoricDays {
    private String user;
    private double totalAttention;
    private ArrayList<Day> days;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getTotalAttention() {
        return totalAttention;
    }

    public void setTotalAttention(double totalAttention) {
        this.totalAttention = totalAttention;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }
}
