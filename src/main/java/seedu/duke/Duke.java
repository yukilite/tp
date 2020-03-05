package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.Map;
import java.util.Scanner;


public class Duke {
    private Ui ui;
    private Parser parser;
    private Storage storage;

    public Duke() {
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





            } catch (Exception e) {
                //TODO replace exception e with a custom exception and print a custom error message.
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
