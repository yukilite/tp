<<<<<<< HEAD:src/main/java/seedu/duke/command/ListCommand.java
package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ListCommand extends Command {
    public static final String MESSAGE_USAGE = "listp : List all the patients.\n"
            + "Example: listp";

    /**
     * Empty constructor. Only used to create the ListCommand object.
     */

    public ListCommand() {
    }

    /**
     * For this execution, the patient list will be displayed.
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     */
    @Override
    public void execute(Ui ui, Storage storage) {

        /** Show the enitre list. This is the onlu method in Ui that is static for some reason **/
        Ui.showEntireList();

    }
}
=======
package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ListPatientCommand extends Command{
    public static final String MESSAGE_USAGE = "listp : List all the patients.\n"
            + "Example: listp";
    /**
     * Empty constructor. Only used to create the ListPatientCommand object
     */
    public ListPatientCommand() {
    }

    /**
     * For this execution, the patient list will be displayed
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     */
    @Override
    public void execute(Ui ui, Storage storage) {

        /** Show the enitre list. This is the onlu method in Ui that is static for some reason **/
        Ui.showEntireList();

    }
}
>>>>>>> 571014192c7f653066554bb6985ff9a6b2306908:src/main/java/seedu/duke/command/ListPatientCommand.java
