package seedu.duke;

import seedu.duke.parser.Parser;
import seedu.duke.record.Patient;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private Ui ui;
    private Parser parser;
    private Storage storage;
    private static PatientList patientList;
    private static AppointmentList appointmentList;

    public Duke() {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage();
    }

    public void startup() {
        List<Patient> patientListToLoad = null;
        List<Appointment> appointmentListToLoad = null;
        try {
            patientListToLoad = storage.loadSavedPatients();
        } catch (FileNotFoundException e) {
            patientListToLoad = new ArrayList<Patient>();
        } finally {
            patientList = new PatientList(patientListToLoad);
        }
        try {
            appointmentListToLoad = storage.loadSavedAppointments();
        } catch (FileNotFoundException e) {
            appointmentListToLoad = new ArrayList<Appointment>();
        } finally {
            appointmentList = new AppointmentList(appointmentListToLoad);
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
        new Duke().run();
    }
}
