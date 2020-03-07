package seedu.duke.storage;

import java.util.List;

import seedu.duke.record.Patient;

public class PatientList {
    private static List<Patient> patientList;

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

    public static int getTotalPatients() {
        return patientList.size();
    }
}
