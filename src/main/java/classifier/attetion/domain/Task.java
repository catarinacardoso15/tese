package classifier.attetion.domain;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    private ArrayList<String> listT;
    private String name;
    private Date time;
    private String user;

    public Task() {
    }

    public Task(String name, Date time, String user) {
        this.listT = new ArrayList<String>();
        this.name = name;
        this.time = time;
        this.user = user;
    }

    public ArrayList<String> getListT() {
        return listT;
    }

    public void setListT(ArrayList<String> listT) {
        this.listT = listT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
