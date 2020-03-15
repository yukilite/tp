package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

/**
 * Show a list of commands and what is the correct input's format
 *
 * @author Nguyen Thanh Duc
 * @version 0.1
 * @since 2020-03-08
 */
public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;
    public static final String COMMANDS_MESSAGE_USAGE = AddPatientCommand.MESSAGE_USAGE
            + "\n" + UpdatePatientCommand.MESSAGE_USAGE
            + "\n" + DeletePatientCommand.MESSAGE_USAGE
            + "\n" + ListPatientCommand.MESSAGE_USAGE
            + "\n" + HelpCommand.MESSAGE_USAGE;

    /**
     * Method to print out all the commands that user can input with usage and examples of them
     *
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @throws IOException when there is error in the index's input
     * @see IOException
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        System.out.println(COMMANDS_MESSAGE_USAGE);
        //TODO Justin ui.showHelpUsage(): can use the printing I just implemented
    }
}
