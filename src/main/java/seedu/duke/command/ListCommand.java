package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ListCommand extends Command{

    /**
     * Empty constructor. Only used to create the ListCommand object
     */
    public ListCommand() {
    }

    /**
     * For this execution, the patient list will be displayed
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     */
    @Override
    public void execute(Ui ui, Storage storage) {

        /** Show the enitre list. This is the onlu method in Ui that is static for some reason **/
        ui.showEntireList();

    }
}
