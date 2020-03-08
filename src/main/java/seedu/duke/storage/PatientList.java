package seedu.duke.storage;

import seedu.duke.record.Patient;

import java.io.IOException;
import java.util.List;

public class PatientList {
    private static List<Patient> patientList;

    public List<Patient> getPatientList() {
        return this.patientList;
    }

    public Patient getPatientRecord(int patientIndex) {
        return this.getPatientList().get(patientIndex);
    }
}
