package seedu.duke.exceptions;

public class DescriptionIsEmptyException extends Exception {
    private String command;

    public DescriptionIsEmptyException(String commandType) {
        this.command = commandType;
    }

    @Override
    public String getLocalizedMessage() {
        return "Please ensure that the description for " + this.command + " is not empty";
    }
}
