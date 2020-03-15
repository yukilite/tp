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
     * Overrides the default toString command so that the patient's appointment.
     * details can be printed in a specific string format.
     * @return newToString The formatted string
     */
    @Override
    public String toString() {
        String newToString = "{" + "[Date]:" + " " + getDate() + " " + "|" + "[Time]:" + " " + getTime() + "}";
        return newToString;
    }

    /**
<<<<<<< HEAD
     * This part is implemented for the UpdatePatientCommand class by Duc.
=======
     * This part is implemented for the EditPatientCommand class by Duc
>>>>>>> deec80bbafadfb9fa0b889dc6b74c32ad147c0b5
     */

    /**
     * Update the name if it is not null.
     *
     * @param date date that needs to be updated
     */
    public void setDate(String date) {
        if (!date.isBlank()) {
            this.date = date;
        }
    }

    /**
     * Update the age if it is a positive integer.
     *
     * @param time time that needs to be updated
     */
    public void setTime(String time) {
        if (!time.isBlank()) {
            this.time = time;
        }
    }

    /**
     * Method to update all the patient's information.
     *
     * @param date date that needs to be updated
     * @param time time that needs to be updated
     */
    public void setAppointmentInfo(String date, String time) {
        setDate(date);
        setTime(time);
    }
}
