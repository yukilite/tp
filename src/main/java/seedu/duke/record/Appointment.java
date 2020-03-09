package seedu.duke.record;

public class Appointment {
    private String date;
    private String time;

    public Appointment(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "{" + "[Date]:" + " " + getDate() + " "+ "|" + "[Time]:" + " " + getTime() + "}";
    }
}
