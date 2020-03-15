package seedu.duke.command;

import seedu.duke.command.Command;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Map;

public class AddAppointmentCommand extends Command {

    public AddAppointmentCommand(Map<String, String> placeholder) {
        //placeholder constructor delete this
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        System.out.println("AddAppointmentCommand is executed (placeholder code)");
    }
}
