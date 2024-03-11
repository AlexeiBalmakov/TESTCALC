import java.awt.*;

public enum ARGS {
    I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"), VIII("8"), IX("9"), X("10");
    public  String number;
    ARGS(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}