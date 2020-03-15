package seedu.duke.ui;

import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the user interface that will interact with the user
 *
 * @author Justin
 */
public class Ui {
    /**
     * This method prints whenever an unknownCommand Exception is caught.
     * TODO: Maybe can improve this to echo the last string that user input
     */
    public void showUnknownCommandError() {
        System.out.println("Unknown command");
    }

    /**
     * This method prints the entire patientList
     */
    public void showEntireList() {
        List<Patient> patientList = PatientList.getPatientList(); //getPatientList() method by @Brandonnn
        for (Patient p : patientList) {
            System.out.println(p); //override Patient class toString by @Sammmmm
        }
    }

    public void showWrongCommandFormatError() {
        System.out.println("Wrong Command Format");
    }

    public void showExceptionError(String localizedMessage) {
        System.out.println(localizedMessage);
    }
}
