package classifier;

import classifier.attetion.domain.UserResult;
import classifier.models.Measure;
import classifier.models.User;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDTO {
    private static String host = "jdbc:mysql://gi6kn64hu98hy0b6.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/y8m51b0v5k4xixb1";
    private static String pass = "eukj7ce727s42u2i";
    private static String username = "g6anxg1tcoqyavj5";

    private Connection connection;
    private Statement statement;

    public MySQLDTO() {
        this.connection = null;
        initiateConnection();
    }

    private void initiateConnection() {
        try {
            connection = DriverManager.getConnection(host, username, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public void insertMeasure(UserResult result, String token) {
        //FALTA INFO TASK (TYPE e dificuldade)
        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("INSERT INTO measures (user,token,time,usefulTime,attention)" +
                    "VALUES ('" + result.getUser() + "','" + token + "'," + result.getTime() + "," + result.getUsefulTime() + "," + result.getAttention() + ")");
            while (r.next()) {
                int id = r.getInt(1);
                statement.execute("INSERT INTO rowdata (id_measure,ma,mv,cd,tbc,dbc,ddc,tdc,dplbc,kdt,tbk)" +
                        "VALUES (" + id + "," + result.getRowData().getMouse().getMa() + "," + result.getRowData().getMouse().getMv() + "," + result.getRowData().getMouse().getCd() +
                        "," + result.getRowData().getMouse().getTbc() + "," + result.getRowData().getMouse().getDbc() + "," + result.getRowData().getMouse().getDdc() +
                        "," + result.getRowData().getMouse().getTdc() + "," + result.getRowData().getMouse().getDplbc() + "," + result.getRowData().getKeyboard().getKdt() +
                        "," + result.getRowData().getKeyboard().getTbk() + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Measure> getMeasuresbyUser(String user) {
        ArrayList<Measure> listMeasure = new ArrayList<Measure>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM measures WHERE user ='" + user + "'");
            while (rs.next()) {
                UserResult u = new UserResult();
                u.setUser(user);
                u.setAttention(rs.getFloat(6));
                u.setTime(Integer.parseInt(rs.getString(4)));
                u.setUsefulTime(Integer.parseInt(rs.getString(5)));
                listMeasure.add(new Measure(u, rs.getInt(1), rs.getInt(7), rs.getInt(8), Long.parseLong(rs.getTimestamp(9).toString())));
            }
            return listMeasure;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Measure> getMeasuresbyToken(String token) {
        ArrayList<Measure> listMeasure = new ArrayList<Measure>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM measures WHERE token ='" + token + "'");
            while (rs.next()) {
                UserResult u = new UserResult();
                u.setUser(rs.getString(2));
                u.setAttention(rs.getFloat(6));
                u.setTime(Integer.parseInt(rs.getString(4)));
                u.setUsefulTime(Integer.parseInt(rs.getString(5)));
                listMeasure.add(new Measure(u, rs.getInt(1), rs.getInt(7), rs.getInt(8), Long.parseLong(rs.getTimestamp(9).toString())));
            }
            return listMeasure;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Measure> getMeasuresbyDate(long timeinicial, long timefinal) {
        ArrayList<Measure> listMeasure = new ArrayList<Measure>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM measures WHERE timestamp BETWEEN " + timeinicial + " AND "+timefinal);
            while (rs.next()) {
                UserResult u = new UserResult();
                u.setUser(rs.getString(2));
                u.setAttention(rs.getFloat(6));
                u.setTime(Integer.parseInt(rs.getString(4)));
                u.setUsefulTime(Integer.parseInt(rs.getString(5)));
                listMeasure.add(new Measure(u, rs.getInt(1), rs.getInt(7), rs.getInt(8), Long.parseLong(rs.getTimestamp(9).toString())));
            }
            return listMeasure;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void insertUser(String user) {
        try {
            statement = connection.createStatement();
            int result = statement.executeUpdate("INSERT INTO user (identifier)" +
                    "VALUES ('" + user + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String user) {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE identifier ='" + user + "'");
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUserAttention(UserResult u) {
        try {
            statement = connection.createStatement();
            int result = statement.executeUpdate("UPDATE user SET attentionScore = " + u.getAttention() + "WHERE identifier ='" + u.getUser() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
