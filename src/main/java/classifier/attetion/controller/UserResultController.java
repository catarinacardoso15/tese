package classifier.attetion.controller;

import classifier.attetion.domain.*;

import java.util.ArrayList;
import java.util.Date;

public class UserResultController {
    private UserResult user;

    public UserResultController() {
        this.user = new UserResult();
    }

    public UserResult getUser(UserData userdata, Date finalDate, ArrayList<Rules> rule) {
        this.user.setUser(userdata.getUser());
        createUserAttention(userdata, finalDate, rule);
        RowData rd = peripheralResults(userdata);
        this.user.setRowData(rd);
        return this.user;
    }


    private void createUserAttention(UserData userdata, Date finalDate, ArrayList<Rules> rule) {
        ArrayList<Task> list = taskToAplication(userdata.getListTask(), rule);
        long time = getTimeAtivity(userdata.getListTask(),finalDate);
        this.user.setTime(time);
        long otherTime = getOtherTime(userdata.getListTask(),finalDate);
        this.user.setUsefulTime(time - otherTime);
        this.user.setAttention((this.user.getUsefulTime()*100)/time);
    }

    private ArrayList<Task> taskToAplication(ArrayList<Task> list, ArrayList<Rules> rules) {
        int t, g;
        for (int i = 0; i < list.size(); i++) {
            t = 0;
            g = 0;
            int fu = 0;

            for (int q = 0; q < rules.size(); q++) {

                switch (rules.get(q).getRegex()) {
                    case 0:
                        if (list.get(i).getName().toUpperCase().contains(rules.get(q).getName().toUpperCase())) {
                            g = 1;
                        }
                        t++;
                        break;
                    case 1:
                        if (list.get(i).getName().toUpperCase().startsWith(rules.get(q).getName().toUpperCase())) {
                            t++;
                            g = 1;
                        }
                        break;
                    case 2:
                        if (list.get(i).getName().toUpperCase().endsWith(rules.get(q).getName().toUpperCase())) {
                            t++;
                            g = 1;
                        }
                        break;
                    case 3:

                        if (list.get(i).getName().toUpperCase().contains(rules.get(q).getName().toUpperCase())) {
                            t++;
                            fu = 1;
                        } else {
                            g = 1;
                            t++;
                        }

                        break;
                    default:
                        break;
                }

                if (t == rules.size()) {

                    if (g == 1 && fu == 0) {
                        ArrayList<String> f = list.get(i).getListT();
                        f.add("task");
                        list.get(i).setListT(f);
                    }
                }

            }
        }
        return list;
    }


    public long getTimeAtivity(ArrayList<Task> listT, Date finalDate) {
        Date initialDate = listT.get(0).getTime();
        for (Task list : listT) {
            if (list.getTime().before(initialDate) || list.getTime().equals(initialDate)) {
                initialDate = list.getTime();
            }
        }
        return finalDate.getTime() - initialDate.getTime();
    }


    public long getOtherTime(ArrayList<Task> listT, Date finalD) {
        long time = 0;
        int i = 0;
        ArrayList<Task> listTaskwork = new ArrayList<Task>();
        for (i = 0; i < listT.size() - 1; i++) {
            if (listT.get(i).getListT().isEmpty()) {
                time = time + (listT.get(i + 1).getTime().getTime() - listT.get(i).getTime().getTime());
            }else{
                listTaskwork.add(listT.get(i));
            }
        }
        if (listT.get(i).getListT().isEmpty()) {
            time = time + (finalD.getTime() - listT.get(i).getTime().getTime());
        }
        return time;
    }


    private RowData peripheralResults(UserData ud) {
        RowData data = new RowData();
        KeyboardResults kr = keyboardResults(ud.getListKeyboard());
        data.setKeyboard(kr);
        MouseResults mr = mouseResults(ud.getListMouse());
        data.setMouse(mr);
        return data;
    }

    private KeyboardResults keyboardResults(ArrayList<Keyboard> key) {
        double[] m = mediaKeyboard(key);
        KeyboardResults kr = new KeyboardResults();
        kr.setKdt(m[0]);
        kr.setTbk(m[1]);
        return kr;
    }

    private double[] mediaKeyboard(ArrayList<Keyboard> key) {
        double[] media = new double[2];
        media[0] = 0.0;
        media[1] = 0.0;
        for (int i = 0; i < key.size(); i++) {
            media[0] = media[0] + key.get(i).getKdt();
            media[1] = media[1] + key.get(i).getTbk();
        }
        media[0] = media[0] / key.size();
        media[1] = media[1] / key.size();
        return media;
    }

    private MouseResults mouseResults(ArrayList<Mouse> mouse) {
        double[] m = mediaMouse(mouse);
        MouseResults mr = new MouseResults();
        mr.setCd(m[2]);
        mr.setDbc(m[3]);
        mr.setDdc(m[4]);
        mr.setDplbc(m[5]);
        mr.setMa(m[0]);
        mr.setMv(m[1]);
        mr.setTbc(m[6]);
        mr.setTdc(m[7]);
        return mr;
    }

    private double[] mediaMouse(ArrayList<Mouse> p) {
        double[] media = new double[8];
        for (int i = 0; i < p.size(); i++) {
            media[0] = media[0] + p.get(i).getMa();
            media[1] = media[1] + p.get(i).getMv();
            media[2] = media[2] + p.get(i).getCd();
            media[3] = media[3] + p.get(i).getDbc();
            media[4] = media[4] + p.get(i).getDdc();
            media[5] = media[5] + p.get(i).getDplbc();
            media[6] = media[6] + p.get(i).getTbc();
            media[7] = media[7] + p.get(i).getTdc();
        }
        int i;
        for (i = 0; i < media.length; i++) {
            media[i] = media[i] / p.size();
        }
        return media;

    }
}
