package seedu.duke.exceptions;

public class unknownCommandException extends Exception {
    public String getLocalizedMessage() {
        return "unknownCommandException";
    }
}
