package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public abstract class Command {

    /**
     * Execution method that will be overriden its child classes (the different command classes
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     */
    public abstract void execute(Ui ui, Storage storage);


}
