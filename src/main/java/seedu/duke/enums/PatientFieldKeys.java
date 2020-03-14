package seedu.duke.enums;

/**
 * This enum reflects the changeable fields for the Patient Class.
 *
 * The only exception is indexNumber, as the indexNumber for each patient is not dependant on the individual,
 * but rather the system (duke).
 *
 * @author Justin
 */
public enum PatientFieldKeys {

    INDEX,
    NAME,
    AGE,
    ADDRESS,
    CONTACT_NUMBER;

    public String toString() {
        switch (this) {
        case INDEX:
            return "index";
        case NAME:
            return "name";
        case AGE:
            return "age";
        case ADDRESS:
            return "address";
        case CONTACT_NUMBER:
            return "phone";
        default:
            return null;
        }
    }
}
