package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ListPatientCommand extends Command {
    public static final String MESSAGE_USAGE = "listp : List all the patients.\n"
            + "Example: listp";
    private static Logger logger = Logger.getLogger("LoggerListPatientCommandClass");

    /**
     * Empty constructor. Only used to create the ListPatientCommand object.
     */

    public ListPatientCommand() {
        logger.log(Level.INFO, "Creating AddPatientCommand object. Rather, it is calling an empty constructor of "
                + "ListPatientCommandClass");
    }

    /**
     * For this execution, the patient list will be displayed.
     * @param ui the ui object which can be used to display text.
     * @param storage the storage object for auto saving function.
     */
    @Override
    public void execute(Ui ui, Storage storage) {


        /** Show the enitre list. This is the only method in Ui that is static for some reason **/
        logger.log(Level.INFO, "Getting Ui class to display the list of appointments");
        Ui.showEntireList();

    }
}