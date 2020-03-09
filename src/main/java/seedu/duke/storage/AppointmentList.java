package seedu.duke.storage;

import java.util.List;

public class AppointmentList {
    private static List<Appointment> appointmentList;

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
}
