package seedu.duke.data;

import seedu.duke.exceptions.InvalidFormatException;

/**
 * Used to validate the format of address.
 *
 * @author DUC
 */
public class Address {

    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Patient's addresses is limited to 64 characters "
            + "including of whitespaces";

    public String address;

    /**
     * Constructor for address.
     *
     * @param address address from the hash map created in Parser
     * @throws InvalidFormatException when the address is invalid
     */
    public Address(String address) throws InvalidFormatException {
        if (!isValidAddress(address)) {
            throw new InvalidFormatException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.address = address;
    }

    private static boolean isValidAddress(String address) {
        return address.length() <= 64 || address.isBlank();
    }

    @Override
    public String toString() {
        return address;
    }
}
