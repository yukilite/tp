package seedu.duke.enums;

import seedu.duke.command.Command;

import java.io.Serializable;


public enum Commands implements Serializable {
    ADDP, EDITP, DELETEP;

    public String toString() {
        switch(this) {
        case ADDP :
            return "addp";
        case EDITP :
            return "editp";
        case DELETEP :
            return "deletep";
        default :
            return null;//TODO
        }
    }

    public static Command getCommandObject(String asString, String commandAsString) {
        return null; //todo
    }
}
