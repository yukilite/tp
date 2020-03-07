package seedu.duke.exceptions;

/**
 * This class throws custom exceptions.
 */
public class DukeExceptions {
    public static void doesKeyExist(String[] keyValue) throws noKeyExistException {
        if (keyValue.length != 2) {
            throw new noKeyExistException();
        }
    }

    public static void unknownCommand() throws unknownCommandException {
        throw new unknownCommandException();
    }
}
