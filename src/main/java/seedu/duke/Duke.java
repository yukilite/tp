package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exceptions.DescriptionIsEmptyException;
import seedu.duke.exceptions.IndexNotIntegerException;
import seedu.duke.exceptions.UnknownCommandException;
import seedu.duke.exceptions.InvalidIndexError;
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


public class Duke {
    public static int patientIndexNumber;
    public static int appointmentIndexNumber;

    private Ui ui;
    private Parser parser;
    private Storage storage;
    private static PatientList patientList;
    private static AppointmentList appointmentList;

    public Duke() {
        patientIndexNumber = 0;
        appointmentIndexNumber = 0;
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
            patientListToLoad = new ArrayList<>();
        } finally {
            patientList = new PatientList(patientListToLoad);
        }
        try {
            appointmentListToLoad = storage.loadSavedAppointments();
        } catch (FileNotFoundException e) {
            appointmentListToLoad = new ArrayList<>();
        } finally {
            appointmentList = new AppointmentList(appointmentListToLoad);
        }
    }

    public void run() {
        startup();
        boolean isExit = false;
        Scanner in = new Scanner(System.in);
        while (!isExit) {
            try {
                String fullCommand = in.nextLine();

                Command c = parser.parseCommand(fullCommand); //return what type of command you should execute
                assert c != null;
                c.execute(ui, storage);
                isExit = c.isExit();

            } catch (UnknownCommandException | DescriptionIsEmptyException | InvalidIndexError | IndexNotIntegerException e) {
                ui.showExceptionError(e.getLocalizedMessage());

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
