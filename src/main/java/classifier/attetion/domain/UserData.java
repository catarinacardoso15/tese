package classifier.attetion.domain;

import java.util.ArrayList;
import java.util.Date;

public class UserData {
    private Date initialDate;
    private Date finalDate;
    private String user;
    private ArrayList<Task> listTask;
    private ArrayList<Mouse> listMouse;
    private ArrayList<Keyboard> listKeyboard;

    public UserData(Date initialDate, Date finalDate, String user, ArrayList<Task> listTask, ArrayList<Mouse> listMouse, ArrayList<Keyboard> listKeyboard) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.user = user;
        this.listTask = listTask;
        this.listMouse = listMouse;
        this.listKeyboard = listKeyboard;
    }

    public UserData() {
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public void setListTask(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    public ArrayList<Mouse> getListMouse() {
        return listMouse;
    }

    public void setListMouse(ArrayList<Mouse> listMouse) {
        this.listMouse = listMouse;
    }

    public ArrayList<Keyboard> getListKeyboard() {
        return listKeyboard;
    }

    public void setListKeyboard(ArrayList<Keyboard> listKeyboard) {
        this.listKeyboard = listKeyboard;
    }
}
