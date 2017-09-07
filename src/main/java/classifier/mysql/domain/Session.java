package classifier.mysql.domain;

import javax.persistence.*;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private int score;
    private int type;
    private String token;
    private Long timestampStart;
    private Long timestampFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(Long timestampStart) {
        this.timestampStart = timestampStart;
    }

    public Long getTimestampFinal() {
        return timestampFinal;
    }

    public void setTimestampFinal(Long timestampFinal) {
        this.timestampFinal = timestampFinal;
    }
}
