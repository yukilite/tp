package seedu.duke.record;

/**
 * This class contains the date and time for each patient.
 */

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

    /**
     * Overrides the default toString command so that the patient's appointment
     * details can be printed in a specific string format.
     * @return newToString The formatted string
     */
    @Override
    public String toString() {
        String newToString = "{" + "[Date]:" + " " + getDate() + " "+ "|" + "[Time]:" + " " + getTime() + "}";
        return newToString;
    }
}
