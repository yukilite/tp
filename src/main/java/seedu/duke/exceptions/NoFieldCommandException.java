package seedu.duke.exceptions;

public class NoFieldCommandException extends Exception {
    private String command;

    public NoFieldCommandException(String commandType) {
        this.command = commandType;
    }

    @Override
    public String getLocalizedMessage() {
        return "Please ensure that the fields for " + this.command + " is provided";
    }
}
