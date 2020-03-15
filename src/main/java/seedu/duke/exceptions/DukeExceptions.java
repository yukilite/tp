package seedu.duke.exceptions;

/**
 * This class throws custom exceptions.
 */
public class DukeExceptions {

    /**
     * This method throws a NoKeyExistException if the key is not found in the input that the user supplied
     *         For example: user input "addp \name Justin \address Pasir Ris"
     *         Key is : "\age"
     *         Since \age cannot be found in user input, this method will throw NoKeyExistException.
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
     * THis method throws a UnknownCommandException when the user supplied in an unknown command.
     * All commands available are listed as final Strings in Parser class.
     *
     * @throws UnknownCommandException when user supplied command are not amongst the final Strings.
     */
    public static void throwUnknownCommand() throws UnknownCommandException {
        throw new UnknownCommandException();
    }

    public static void isCommandFormatCorrect(String[] splits) throws WrongCommandFormatException {
        if (splits.length != 2) {
            throw new WrongCommandFormatException();
        }
    }

    public static void isCommandDescriptionEmpty(String[] commandParsed) throws DescriptionIsEmptyException {
        if (commandParsed.length != 2) {
            throw new DescriptionIsEmptyException(commandParsed[0]);
        }
    }

    public static void checkIndexValidity(String indexAsString, String command) throws InvalidIndexError, IndexNotIntegerException {
        try {
            int index = Integer.parseInt(indexAsString);
            if (index <= 0) {
                throw new InvalidIndexError(command);
            }

        } catch (NumberFormatException e) {
            throw new IndexNotIntegerException(command);
        }
    }
}
