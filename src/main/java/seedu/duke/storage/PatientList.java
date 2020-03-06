package seedu.duke.storage;

import java.util.List;
import java.util.ArrayList;

import seedu.duke.record.Patient;

public class PatientList {
    private List<Patient> patientList;

    //constructor if no existing save file, create new list
    public PatientList(){
        this.patientList = new ArrayList<>();
    }

    //constructor if there is existing save file
    public PatientList(List<Patient> savedPatientList) {
        this.patientList = savedPatientList;
    }

    public List<Patient> getPatientList() {
        return this.patientList;
    }

    public void setPatientList(List patientListInput) {
        this.patientList = patientListInput;
    }

    public Patient getPatientRecord(int patientIndex) {
        return this.getPatientList().get(patientIndex);
    }

    public int getTotalPatients() {
        return this.patientList.size();
    }
}
