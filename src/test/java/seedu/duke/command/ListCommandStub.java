package seedu.duke.command;

import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import java.util.List;

public class ListCommandStub {
    public ListCommandStub() {
    }

    public void execute(int ui, int storage) {
        List<PatientStub> patientListStub = PatientListStub.getPatientList(); //getPatientList() method by @Brandonnn
        for (PatientStub p : patientListStub) {
            System.out.println(p); //override Patient class toString by @Sammmmm
        }
    }
}
