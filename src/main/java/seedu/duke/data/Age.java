package seedu.duke.data;

import seedu.duke.exceptions.InvalidFormatException;
import seedu.duke.ui.Ui;

/**
 * Class to validate age.
 */
public class Age {

    public static final String MESSAGE_NAME_CONSTRAINTS = "The format of age is postive integer within 0 and 150";

    public int age;

    /**
     * Constructor for Age.
     *
     * @param age getting from Parser
     * @throws InvalidFormatException when age is invalid
     */
    public Age(String age) throws InvalidFormatException {
        boolean isAgeEqualNull = age.isBlank();
        if (isAgeEqualNull) {
            this.age = -1;
        } else {
            try {
                this.age = Integer.parseInt(age);
            } catch (NumberFormatException e) {
                Ui.showSetAgeError();
                this.age = -1;
            }
        }
        if (!isValidAge(this.age) && !isAgeEqualNull) {
            throw new InvalidFormatException(MESSAGE_NAME_CONSTRAINTS);
        }
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 150;
    }

    public int getAge() {
        return age;
    }
}
