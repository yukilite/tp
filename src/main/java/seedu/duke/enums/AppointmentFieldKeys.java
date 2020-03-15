package seedu.duke.enums;


/**
 * This enum reflects the changeable fields for the Appointment class under the package "record".
 *
 * @author Justin.
 * @see seedu.duke.record.Appointment
 */
public enum AppointmentFieldKeys {
    INDEX,
    DATE,
    TIME;

    @Override
    public String toString() {
        switch(this) {
        case INDEX:
            return "index";
        case DATE:
            return "date";
        case TIME:
            return "time";
        default:
            return null;
        }
    }
}
