package seedu.duke.command;

import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

/**
 * Super class for all the types of command sub-classes
 */
public abstract class Command {

    /**
     * Execution method that will be overriden its child classes (the different command classes
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @param patientList the patient list object which is used for modification to the patients
     */
    public abstract void execute(Ui ui, Storage storage, PatientList patientList) throws IOException;
}
