package seedu.duke.ui;

import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import java.util.List;


/**
 * Represents the user interface that will interact with the user.
 *
 * @author Justin
 */
public class Ui {

    /**
     * This method prints the entire patientList.
     */
    public static void showEntireList() {
        List<Patient> patientList = PatientList.getPatientList(); //getPatientList() method by @Brandonnn
        for (Patient p : patientList) {
            System.out.println(p); //override Patient class toString by @Sammmmm
        }
    }

    public static void showEntireAppointmentList() {
        System.out.println("Show all appointment list");
    }

    public void showWrongCommandFormatError() {
        System.out.println("Wrong Command Format");
    }

    public void showExceptionError(String localizedMessage) {
        System.out.println(localizedMessage);
    }

    public void showAppointmentAddSuccess() {
        System.out.println("Appointment add success!");
    }
}
