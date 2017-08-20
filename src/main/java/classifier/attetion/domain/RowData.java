package classifier.attetion.domain;

public class RowData {
    private MouseResults mouse;
    private KeyboardResults keyboard;

    public RowData() {
    }

    public RowData(MouseResults mouse, KeyboardResults keyboar) {
        this.mouse = mouse;
        this.keyboard = keyboar;
    }

    public MouseResults getMouse() {
        return mouse;
    }

    public void setMouse(MouseResults mouse) {
        this.mouse = mouse;
    }

    public KeyboardResults getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(KeyboardResults keyboar) {
        this.keyboard = keyboar;
    }
}
