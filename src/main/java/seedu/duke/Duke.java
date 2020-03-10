package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exceptions.unknownCommandException;
import seedu.duke.parser.Parser;
import seedu.duke.record.Appointment;
import seedu.duke.record.Patient;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Duke {
    public static int indexNumber;

    private Ui ui;
    private Parser parser;
    private Storage storage;
    private static PatientList patientList;
    private static AppointmentList appointmentList;

    public Duke() {
        indexNumber = 0;
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

    public void run() {
        startup();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readFromUser();

                Command c = parser.parseCommand(fullCommand); //return what type of command you should execute
                assert c != null;
                c.execute(ui, storage);

            } catch (unknownCommandException e) {
                ui.showUnknownCommandError();
            } catch (IOException e) {
                //todo justin ui print error message
            }

        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main (String[] args) {
        new Duke().run();
    }
}
