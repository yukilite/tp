package seedu.duke.command;

import seedu.duke.storage.PatientList;
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
        String helpCommandPrinter = AddCommand.MESSAGE_USAGE
                            + "\n" + UpdateCommand.MESSAGE_USAGE
                            + "\n" + DeleteCommand.MESSAGE_USAGE
                            + "\n" + ListCommand.MESSAGE_USAGE
                            + "\n" + HelpCommand.MESSAGE_USAGE;
        //todo move this to UI for printing
        System.out.println(helpCommandPrinter);
    }
}
