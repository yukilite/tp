package seedu.duke.command;

import seedu.duke.record.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Stub class for patientlist class
 */
public class PatientListStub {
    private static List<PatientStub> patientList = new ArrayList<>();

    public PatientListStub(int choice) {

    }

    public static List<PatientStub> getPatientList() {
        return patientList;
    }

    public static int getTotalPatients() {
        return patientList.size();
    }

    public static void createList(int choice) {
        if (choice == 1) {
            PatientStub newPatient1 = new PatientStub("s;dlskd;l", 23, "Li", "121");
            PatientStub newPatient2 = new PatientStub(" ", 15, " ", "15454455");
            PatientStub newPatient3 = new PatientStub("ewuioaiwoe", 33, "Lo", "1989");
            PatientStub newPatient4 = new PatientStub("aeiwae", 13, "to", " ");
            PatientStub newPatient5 = new PatientStub("LSDs", -1, "Lis", "12");
            patientList.add(newPatient1);
            patientList.add(newPatient2);
            patientList.add(newPatient3);
            patientList.add(newPatient4);
            patientList.add(newPatient5);
        }
    }
}