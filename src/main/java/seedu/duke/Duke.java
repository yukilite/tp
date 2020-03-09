package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exceptions.unknownCommandException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;


public class Duke {
    public static int indexNumber;

    private Ui ui;
    private Parser parser;
    private Storage storage;

    public Duke() {
        indexNumber = 0;
        ui = new Ui();
        parser = new Parser();
        storage = new Storage();
    }

    public void run() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readFromUser();

                Command c = parser.parseCommand(fullCommand); //return what type of command you should execute
                assert c != null;
                //TODO for @andy after getting command object, what to do with it? Command object will never be null

            } catch (unknownCommandException e) {
                ui.showUnknownCommandError();
            }
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}
