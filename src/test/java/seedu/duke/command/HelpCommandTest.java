package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.*;

class HelpCommandTest {

    @Test
    void execute() throws Exception{
        Command command = new HelpCommand();
        Ui ui = new Ui();
        Storage storage = new Storage();
        command.execute(ui,storage);
    }
}