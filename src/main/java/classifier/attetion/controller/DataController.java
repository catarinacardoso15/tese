package classifier.attetion.controller;

import Controller.DataBaseController;
import Model.TaskRecords;
import Model.User;
import classifier.attetion.domain.*;
import classifier.attetion.dto.Mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DataController {
    private Data data;
    private Mongo connectionMongo;

    public DataController() {
        this.data = new Data();
        this.connectionMongo = new Mongo();
    }

    public DataController(Data data) {
        this.data = data;
        this.connectionMongo = new Mongo();
    }

    public Data createData(Date i, Date f) {
        ArrayList<Task> a = getAplications(i, f);
        data.setUsersResult(getUserTask(a));
        data.setFinalDate(f);
        data.setInitialDate(i);
        data.getUsersResult().forEach(d -> {
            getDados(d.getInitialDate(), d.getFinalDate(), d);

        });
        return data;
    }


    public ArrayList<Task> getAplications(Date i, Date f) {
        ArrayList<TaskRecords> records = connectionMongo.getTaskDate(i, f);
        ArrayList<Task> listT = new ArrayList<Task>();
        records.forEach(taskRecords -> listT.addAll(getTaskFromRecords(taskRecords)));
        return listT;
    }

    public ArrayList<Task> getAplications(Date i, Date f, String nameUser) {
        User user = connectionMongo.getTaskUser(i, f, nameUser);
        ArrayList<TaskRecords> records = user.getTask();
        ArrayList<Task> listT = new ArrayList<Task>();
        records.forEach(taskRecords -> listT.addAll(getTaskFromRecords(taskRecords)));
        return listT;
    }

    public ArrayList<Task> getTaskFromRecords(TaskRecords t) {
        ArrayList<Task> listT = new ArrayList<Task>();
        t.getTasks().forEach(task -> {
            if (!task.getName().equals("")) {
                listT.add(new Task(task.getName(), task.getData(), t.getUser()));
            }
        });
        return listT;
    }

    public ArrayList<Mouse> getMouse(Date i, Date f, String user) {

        User u = connectionMongo.getMouseUser(i, f, user);

        ArrayList<Mouse> listM = new ArrayList<Mouse>();
        u.getMouse().forEach(r -> listM.add(new Mouse(r.getMv(), r.getMa(), r.getCd(), r.getTbc(), r.getDbc(), r.getDdc()
                , r.getEdbc(), r.getAedbc(), r.getSsdbc(), r.getAsdbc(), r.getTdc(), r.getDplbc(),
                r.getAdpbc(), r.getDate().getTime())));


        return listM;
    }

    public ArrayList<Keyboard> getKeyboard(Date i, Date f, String user) {
        User u = connectionMongo.getKeyboardUser(i, f, user);
        ArrayList<Keyboard> listM = new ArrayList<Keyboard>();
        u.getKeyboard().forEach(r -> listM.add(new Keyboard(r.getDate().getTime(), r.getKdt(), r.getTbk())));
        return listM;
    }

    public UserData getDados(Date i, Date f, UserData user) {
        User u = connectionMongo.getMouseKeyboardUser(i, f, user.getUser());
        ArrayList<Keyboard> listK = new ArrayList<Keyboard>();
        ArrayList<Mouse> listM = new ArrayList<Mouse>();
        u.getMouse().forEach(r -> listM.add(new Mouse(r.getMv(), r.getMa(), r.getCd(), r.getTbc(), r.getDbc(), r.getDdc(), r.getEdbc(),
                r.getAedbc(), r.getSsdbc(), r.getAsdbc(), r.getTdc(), r.getDplbc(), r.getAdpbc(), r.getDate().getTime())));
        user.setListMouse(listM);
        u.getKeyboard().forEach(r -> listK.add(new Keyboard(r.getDate().getTime(), r.getKdt(), r.getTbk())));
        user.setListKeyboard(listK);
        return user;
    }

    public ArrayList<UserData> getUserTask(ArrayList<Task> p) {
        HashMap<String, ArrayList<Task>> listU = new HashMap<String, ArrayList<Task>>();
        p.forEach(app -> {
            if (listU.containsKey(app.getUser())) {
                ArrayList<Task> f = listU.get(app.getUser());
                f.add(app);
                listU.remove(app.getUser());
                listU.put(app.getUser(), f);
            } else {
                ArrayList<Task> f = new ArrayList<Task>();
                f.add(app);
                listU.put(app.getUser(), f);
            }

        });
        ArrayList<UserData> d = new ArrayList<UserData>();

        for (String key : listU.keySet()) {
            UserData result = new UserData();
            result.setUser(key);
            result.setListTask(listU.get(key));
            d.add(result);
        }
        return d;
    }
}
