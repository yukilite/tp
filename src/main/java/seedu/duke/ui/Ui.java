package seedu.duke.ui;

import seedu.duke.record.Appointment;
import seedu.duke.record.Patient;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.PatientList;

import java.util.List;

/**
 * Represents the user interface that will interact with the user.
 *
 * @author Justin
 */
public class Ui {

    /**
     * Prints the entire patientList.
     */
    public static void showEntirePatientList() {
        List<Patient> patientList = PatientList.getPatientList(); //getPatientList() method by @Brandonnn
        for (Patient p : patientList) {
            System.out.println(p); //override Patient class toString by @Sammmmm
        }
    }

    /**
     * Prints the entire appointmentList.
     */
    public static void showEntireAppointmentList() {
        List<Appointment> appointmentList = AppointmentList.getAppointmentList();
        for (Appointment a : appointmentList) {
            System.out.println(a);
        }
    }

    public static void showNumberError() {
        System.out.println("Please input an integer for index");
    }

    public static void showIndexError() {
        System.out.println("Index out of bound, please check the correct index from the list");
    }

    public static void showNoFieldError() {
        System.out.println("Please do not let the information be empty");
    }

    public static void showDeleteAppointmentSuccess() {
        System.out.println("Appointment deleted successfully!");
    }

    public static void showDeletePatientSuccess() {
        System.out.println("Patient deleted successfully!");
    }

    public static void showUpdateAppointmentSuccess() {
        System.out.println("Appointment updated successfully!");
    }

    public static void showSetAgeError() {
        System.out.println("Received a non-integer for age, setting age to be -1.");
    }

    public static void showUpdatePatientSuccess() {
        System.out.println("Patient updated successfully!");
    }

    public static void showByeMessage() {
        System.out.println("Bye!");
    }

    public static void showHelpUsage(String commandsMessageUsage) {
        System.out.println(commandsMessageUsage);
    }


    public void showExceptionError(String localizedMessage) {
        System.out.println(localizedMessage);
    }

    public void showAppointmentAddSuccess() {
        System.out.println("Appointment added successfully!");
    }

    public void showPatientAddSuccess() {
        System.out.println("Patient added successfully");
    }
}
