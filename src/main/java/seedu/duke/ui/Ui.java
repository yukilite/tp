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
     * Empty Ui constructor.
     */
    public Ui() {

    }

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

    public static void showFailedToCreateFile() {
        System.out.println("Failed to create file in new directory");
    }

    public static void showFailedToCreateDirectory() {
        System.out.println("Failed to create directory");
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

    /**
     * Prints HAMS logo.
     */
    public void printHello() {
        System.out.println("            .---------.\n"
                + "       _    |:: [-=-] |\n"
                + "      | |   |_________|\n"
                + "      |~|\n"
                + "      |_|                    ,;;;;,\n"
                + "       I\\  ,__ ,;;;, __,    ///\\\\\\\\\\\n"
                + "       I |{   / . . \\   }   / \"  \\\\||\n"
                + "       I | ) (   _   ) (    \\_= _///\n"
                + "       I |{___'-. .-'___}\\___ )_\\\n"
                + "       I ||~/,'~~~~~,\\~~|'---((  \\\n"
                + "       I \\ //        \\\\ |     \\ \\ \\\n"
                + "       I  \\/         // |     | /-/\n"
                + "       I (/         (/  |     |/||\\\n"
                + "       I  |             |     |    |\n"
                + "       I  |             |     |____/\n"
                + "       I  :-----_o_-----:      || |\n"
                + "       I  | /~~|===|~~\\ |      (( |\n"
                + "       I  ||   |===|   ||      ||_/\n"
                + "      /^\\ \"~   '^^^'   \"\"     ((__|");

        System.out.println(" ____      ____  ________  _____       ______    ___   ____    ____  ________  \n"
                + "|_  _|    |_  _||_   __  ||_   _|    .' ___  | .'   `.|_   \\  /   _||_   __  | \n"
                + "  \\ \\  /\\  / /    | |_ \\_|  | |     / .'   \\_|/  .-.  \\ |   \\/   |    | |_ \\_| \n"
                + "   \\ \\/  \\/ /     |  _| _   | |   _ | |       | |   | | | |\\  /| |    |  _| _  \n"
                + "    \\  /\\  /     _| |__/ | _| |__/ |\\ `.___.'\\\\  `-'  /_| |_\\/_| |_  _| |__/ | \n"
                + "     \\/  \\/     |________||________| `.____ .' `.___.'|_____||_____||________| \n"
                + "                                                                               ");
        printLongSeparator();
        System.out.println("Hello I am HAMS. What can I do for you today?");
    }

    private String printSeparator() {
        return "========================================================================";
    }

    public void printLongSeparator() {
        System.out.println(printSeparator() + printSeparator());
    }

}
