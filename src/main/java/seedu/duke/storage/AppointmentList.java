package seedu.duke.storage;

import seedu.duke.record.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentList {
    private static List<Appointment> appointmentList;

    public AppointmentList() {
        this.appointmentList = new ArrayList<>();
    }

    public AppointmentList(List<Appointment> savedPatientList) {
        this.appointmentList = savedPatientList;
    }

    //getter and setter
    public List<Appointment> getAppointmentList() {
        return this.appointmentList;
    }

    public void setAppointmentList(List appointmentListInput) {
        this.appointmentList = appointmentListInput;
    }

    public Appointment getAppointmentRecord(int appointmentIndex) {
        return this.getAppointmentList().get(appointmentIndex);
    }

    public static int getTotalAppointments() {
        return appointmentList.size();
    }

    public void removeAppointmentRecord(int appointmentIndex) {
        this.getAppointmentList().remove(appointmentIndex-1);
    }
}
