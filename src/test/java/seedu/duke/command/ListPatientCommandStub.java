package seedu.duke.command;

import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import java.util.List;

/**
 * Stub class for ListPatientCommand.
 */
public class ListPatientCommandStub {
    public ListPatientCommandStub() {
    }

    /**
     * Stub to simulate adding patients into list.
     *
     * @param ui stub ui
     * @param storage stub storage
     */
    public void execute(int ui, int storage) {
        List<PatientStub> patientListStub = PatientListStub.getPatientList(); //getPatientList() method by @Brandonnn
        for (PatientStub p : patientListStub) {
            System.out.println(p); //override Patient class toString by @Sammmmm
        }
    }
}
