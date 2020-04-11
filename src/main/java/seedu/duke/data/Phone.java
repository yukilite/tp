package seedu.duke.data;

import seedu.duke.exceptions.InvalidFormatException;

/**
 * Class for phone's validation.
 *
 * @author DUC
 */
public class Phone {

    public static final String MESSAGE_PHONE_CONSTRAINTS = "Patient's phone numbers should contain 8 numbers "
            + "and no whitespaces between digits";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";

    public String phone;

    /**
     * Constructor of Phone.
     *
     * @param phone getting from Parser
     * @throws InvalidFormatException when phone is invalid
     */
    public Phone(String phone) throws InvalidFormatException {
        if (!isValidPhone(phone)) {
            throw new InvalidFormatException(MESSAGE_PHONE_CONSTRAINTS);
        }
        this.phone = phone;
    }

    public static boolean isValidPhone(String phone) {
        return (phone.matches(PHONE_VALIDATION_REGEX) && phone.length() == 8) || phone.isBlank();
    }

    @Override
    public String toString() {
        return phone;
    }
}
