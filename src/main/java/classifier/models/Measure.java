package classifier.models;

import classifier.attetion.domain.UserResult;

public class Measure {

    private UserResult user;
    private int id;
    private int typeTask;
    private int difficultyTask;
    private long timestamp;

    public Measure(UserResult user, int id, int typeTask, int difficultyTask, long timestamp) {
        this.user = user;
        this.id = id;
        this.typeTask = typeTask;
        this.difficultyTask = difficultyTask;
        this.timestamp = timestamp;
    }

    public UserResult getUser() {
        return user;
    }

    public void setUser(UserResult user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(int typeTask) {
        this.typeTask = typeTask;
    }

    public int getDifficultyTask() {
        return difficultyTask;
    }

    public void setDifficultyTask(int difficultyTask) {
        this.difficultyTask = difficultyTask;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}