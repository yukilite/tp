package seedu.duke.exceptions;

import java.util.Map;

/**
 * This class throws custom exceptions.
 */
public class DukeExceptions {

    /**
     * This method throws a NoKeyExistException if the key is not found in the input that the user supplied
     * For example: user input "addp \name Justin \address Pasir Ris"
     * Key is : "\age"
     * Since \age cannot be found in user input, this method will throw NoKeyExistException.
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
     * This method throws a UnknownCommandException when the user supplied in an unknown command.
     * All commands available are listed as final Strings in Parser class.
     *
     * @throws UnknownCommandException when user supplied command are not amongst the final Strings.
     */
    public static void throwUnknownCommand() throws UnknownCommandException {
        throw new UnknownCommandException();
    }

    /**
     * Throws a DescriptionIsEmptyException when the commandParsed length is not 2.
     * Since commandParsed is split by a delimiter with a limit of 2, if there is a description the length will be 2.
     *
     * @param commandParsed the full command that was parsed by a delimiter
     * @throws DescriptionIsEmptyException throws exception when length is not 2
     */
    public static void isCommandDescriptionEmpty(String[] commandParsed) throws DescriptionIsEmptyException {
        if (commandParsed.length != 2) {
            throw new DescriptionIsEmptyException(commandParsed[0]);
        }
    }

    /**
     * Checks the validity of the index. If it is not valid, throws one of the two exceptions.
     *
     * @param indexAsString The index as a string
     * @param command       The command that called this method
     * @throws InvalidIndexException    Throws an InvalidIndexException when the index supplied is <= 0
     * @throws IndexNotIntegerException Throws an IndexNotIntegerException when the index supplied is not an integer
     */
    public static void checkIndexValidity(String indexAsString, String command) throws InvalidIndexException,
            IndexNotIntegerException {
        try {
            int index = Integer.parseInt(indexAsString);
            if (index <= 0) {
                throw new InvalidIndexException(command);
            }

        } catch (NumberFormatException e) {
            throw new IndexNotIntegerException(command);
        }
    }

    /**
     * Throws a noFieldCommandException when the user did not include any fields in the full command.
     *
     * @param map a HashMap that contains all the fields to be included.
     * @throws NoFieldCommandException Throws a NoFieldCommandException when none of the fields are included
     */
    public static void noFieldCommand(Map<String, String> map, String command) throws NoFieldCommandException {
        int count = 0;

        for (Map.Entry mapElement : map.entrySet()) {
            if (mapElement.getValue() == "") {
                count++;
            }
        }

        if (count == map.size()) {
            throw new NoFieldCommandException(command);
        }
    }
}
