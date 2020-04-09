package seedu.duke.exceptions;

public class InvalidDateTimeException extends Exception {
    @Override
    public String getLocalizedMessage() {
        return "Please fill in date in right format: dd/mm/yyyy and time in the 24 hour format: hhmm";
    }
}
