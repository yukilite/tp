package seedu.duke.exceptions;

public class UnknownCommandException extends Throwable {
    @Override
    public String getLocalizedMessage() {
        return "Unknown command";
    }
}
