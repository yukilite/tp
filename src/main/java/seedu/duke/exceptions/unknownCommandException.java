package seedu.duke.exceptions;

public class UnknownCommandException extends Exception {
    public String getLocalizedMessage() {
        return "Unknown Command";
    }
}
