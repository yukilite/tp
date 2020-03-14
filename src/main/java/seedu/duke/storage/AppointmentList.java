package seedu.duke.storage;

import seedu.duke.record.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentList {
    private static List<Appointment> appointmentList;

    public AppointmentList() {
        appointmentList = new ArrayList<>();
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
}
