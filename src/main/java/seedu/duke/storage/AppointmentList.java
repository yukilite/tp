package seedu.duke.storage;

import java.util.ArrayList;
import java.util.List;

import seedu.duke.record.Patient;

public class AppointmentList {
    private List<Appointment> appointmentList;

    //if no existing save file, create new list
    public AppointmentList(){
        this.appointmentList = new ArrayList<>();
    }

    //if there is existing save file
    public AppointmentList(List<Appointment> savedPatientList) {
        this.appointmentList = savedPatientList;
    }

    //getter and setter
    public List<Appointment> getAppointmentList() {
        return this.appointmentList;
    }

    public void setAppointmentList(List appointmentListnput) {
        this.appointmentList = appointmentListnput;
    }
    public Appointment getAppointmentRecord(int appointmentIndex) {
        return this.getAppointmentList().get(appointmentIndex);
    }

    public int getTotalAppointments() {
        return this.appointmentList.size();
    }
}
