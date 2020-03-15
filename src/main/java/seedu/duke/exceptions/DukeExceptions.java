package seedu.duke.exceptions;

import seedu.duke.storage.PatientList;

import java.util.Map;

/**
 * This class throws custom exceptions.
 */
public class DukeExceptions {

    /**
     * This method throws a noKeyExistException if the key is not found in the input that the user supplied
     *         For example: user input "addp \name Justin \address Pasir Ris"
     *         Key is : "\age"
     *         Since \age cannot be found in user input, this method will throw noKeyExistException.
     *
     * @param keyValue the key value pair "Key => value" as a size = 2 String array.
     * @throws NoKeyExistException throws exception when there is no key associated with any value.
     */
    public static void doesKeyExist(String[] keyValue) throws NoKeyExistException {
        if (keyValue.length != 2) {
            throw new NoKeyExistException();
        }
    }

    /**
     * THis method throws a unknownCommandException when the user supplied in an unknown command.
     * All commands available are listed as final Strings in Parser class.
     *
     * @throws UnknownCommandException when user supplied command are not amongst the final Strings.
     */
    public static void unknownCommand() throws UnknownCommandException {
        throw new UnknownCommandException();
    }

    public static void noFieldCommand(Map<String, String> map) throws NoFieldCommandException {
        int count = 0;
        for (Map.Entry mapElement: map.entrySet()) {
            if (mapElement.getValue() == "") {
                count++;
            }
        }
        if (count == map.size()) {
            throw new NoFieldCommandException();
        }
    }
}
