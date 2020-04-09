package seedu.duke.exceptions;

public class InvalidPhoneNumberException extends Exception {

    @Override
    public String getLocalizedMessage() {
        return "Invalid phone number, please enter a valid Singapore phone number.";
    }
}
