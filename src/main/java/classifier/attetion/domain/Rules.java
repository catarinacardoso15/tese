package classifier.attetion.domain;

public class Rules {
    private String name;
    private int regex;

    public Rules() {
    }

    public Rules(String name, int regex) {
        this.name = name;
        this.regex = regex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegex() {
        return regex;
    }

    public void setRegex(int regex) {
        this.regex = regex;
    }
}
