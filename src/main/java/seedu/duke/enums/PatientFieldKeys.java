package seedu.duke.enums;

/**
 * This enum reflects the changeable fields for the Patient Class.
 *
 * @author Justin
 *
 * The only exception is indexNumber, as the indexNumber for each patient is not dependant on the individual,
 * but rather the system (duke).
 */
public enum PatientFieldKeys {

    NAME,
    AGE,
    ADDRESS;

    public String toString() {
        switch(this) {
        case NAME :
            return "name";
        case AGE :
            return "age";
        case ADDRESS :
            return "address";
        default :
            return null;//TODO
        }
    }
}
