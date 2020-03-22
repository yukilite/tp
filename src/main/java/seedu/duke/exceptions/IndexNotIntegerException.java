package seedu.duke.exceptions;

public class IndexNotIntegerException extends Exception {
    private String command;

    public IndexNotIntegerException(String commandType) {
        this.command = commandType;
    }

    @Override
    public String getLocalizedMessage() {
        return "Please input a valid integer as the index for the command " + command;
    }
}
