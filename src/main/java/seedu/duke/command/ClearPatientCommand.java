package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.text.ParseException;

public class ClearPatientCommand extends Command {
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, ParseException {
        //skeleton for duc remove this print statement
        System.out.println("This is ClearPatientCommand");
    }
}
