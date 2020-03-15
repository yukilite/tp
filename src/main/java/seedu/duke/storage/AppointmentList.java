package seedu.duke.storage;

import seedu.duke.record.Appointment;

import java.util.ArrayList;
import java.util.List;

/**
 * This class acts an ADT for the list containing existing Appointment objects. It contains various getter/setter methods
 * for accessing the different attributes and methods for manipulating the data structure.
 *
 * @author Brandon Chong
 * @version 1.0
 * @since 2020-03-14
 */
public class AppointmentList {
    private static List<Appointment> appointmentList;

    public AppointmentList() {
        this.appointmentList = new ArrayList<>();
    }

    public AppointmentList(List<Appointment> savedPatientList) {
        this.appointmentList = savedPatientList;
    }

    //getter and setter
    public static List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List appointmentListInput) {
        this.appointmentList = appointmentListInput;
    }

    public static Appointment getAppointmentRecord(int appointmentIndex) {
        return getAppointmentList().get(appointmentIndex);
    }

    public static int getTotalAppointments() {
        return appointmentList.size();
    }

    public void removeAppointmentRecord(int appointmentIndex) {
        this.getAppointmentList().remove(appointmentIndex);
    }
}
