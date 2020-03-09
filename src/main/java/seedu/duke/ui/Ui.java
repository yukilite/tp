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
    private String logo;
    private String userName;

    /**
     * A constructor for the class Ui. This constructor will run the startup procedures of geting the user's
     * name and greeting him.
     */
    public Ui() {
//        this.logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        startUpGreetings();
    }

    /**
     * Final modifier to prevent method overriding.
     *
     * @see
     * <a href="https://stackoverflow.com/questions/3404301/whats-wrong-with-overridable-method-calls-in-constructors">
     * What's wrong with overridable method calls in constructors</a>
     */
    public final void startUpGreetings() {
        System.out.println("Hello from\n" + logo);

        getUserName();

        System.out.println("Hello " + userName);
    }

    /**
     * Final modifier to prevent method overriding.
     *
     * @see #startUpGreetings().
     */
    public final void getUserName() {
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        this.userName = in.nextLine();
    }

    /**
     * Returns a string that captures the entire user input
     *
     * @return entire user input
     */
    public String readFromUser() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

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
    public static void showEntireList() {
        List<Patient> patientList = PatientList.getPatientList(); //getPatientList() method by @Brandonnn
        for (Patient p : patientList) {
            System.out.println(p); //override Patient class toString by @Sammmmm
        }
    }
}
