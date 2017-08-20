package classifier.attetion.domain;

import java.util.ArrayList;
import java.util.Date;

public class Data {
    private Date initialDate;
    private Date finalDate;
    private ArrayList<UserData> userdata;

    public Data() {
    }

    public Data(Date initialDate, Date finalDate, ArrayList<UserData> usersResult) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.userdata = usersResult;
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

    public ArrayList<UserData> getUsersResult() {
        return userdata;
    }

    public void setUsersResult(ArrayList<UserData> usersResult) {
        this.userdata = usersResult;
    }
}
