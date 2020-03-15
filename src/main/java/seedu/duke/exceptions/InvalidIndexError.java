package seedu.duke.exceptions;

public class InvalidIndexError extends Exception {
    private String command;

    public InvalidIndexError(String commandType) {
        this.command = commandType;
    }

    @Override
    public String getLocalizedMessage() {
        return "Please sure that the index for " + this.command + " is valid";
    }
}
