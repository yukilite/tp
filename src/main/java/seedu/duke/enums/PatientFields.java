package seedu.duke.enums;

public enum PatientFields {
    NAME, AGE, ADDRESS;

    public String toString() {
        switch(this) {
        case NAME :
            return "\\name";
        case AGE :
            return "\\age";
        case ADDRESS:
            return "\\address";
        default :
            return null;//TODO
        }
    }
}
