package seedu.duke.command;

public class AddCommand extends Command{
    public static final String COMMAND_WORD = "addp";
    public static final String EXAMPLE = "addp \\name Duc  \\address Clementi \\number 83487846";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + EXAMPLE;
}
