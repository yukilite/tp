package seedu.duke.parser;

import seedu.duke.Duke;
import seedu.duke.command.*;
import seedu.duke.enums.PatientFieldKeys;
import seedu.duke.exceptions.DukeExceptions;
import seedu.duke.exceptions.noKeyExistException;
import seedu.duke.exceptions.unknownCommandException;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private static final int COMMAND_INDEX = 0;
    private static final int LIMIT = 2;
    private static final int VALUE_STRING_INDEX = 1;
    private static final int VALUE_INDEX = 0;

    private static final String ADD_PATIENT = "addp";
    private static final String EDIT_PATIENT = "editp";
    private static final String DELETE_PATIENT = "deletep";
    private static final String LIST_PATIENT = "listp";

    public static final String REGEX_BACKSLASH = "\\\\";
    private static final String BLANK_STRING = "";
    private static final String WHITESPACE = " ";
    private static final String INDEX = "index";

    /**
     * This methods returns the command from the user input string.
     *
     * @param fullCommand the user input string
     * @return the actual command to execute
     */
    private String getCommand(String fullCommand) {
        String[] splits = fullCommand.split(REGEX_BACKSLASH, LIMIT);
        return splits[COMMAND_INDEX].trim();
    }

    /**
     * This method returns strictly the String that is between the fieldKey and " \" delimiter.
     * It will only return the value that is behind the first key.
     * Returns an empty String if the key supplied cannot be found in the fullCommand
     * For example: param fullCommand = "addp \name Justin \address Pasir Ris \name Ananda"
     * Supplied key is "\name"
     * Default delimiter is "\"
     * Returns String value "Justin" since it is the value behind the first key
     * <p>
     * Note: This method only searches of known keys (key values in the patient field enum). Therefore, any
     * unknown keys in the full command will be ignore.
     * For example: param fullCommand = "addp \name Justin \adress Pasir Ris \age 20"
     * "\adress" will be ignored as it is a mis-spelling of the enum fieldKeys "address".
     * <p>
     * Note: The default delimiter in this method is exactly " \". Any sequence of characters that does not follow this
     * delimiter will be considered as the value to the key.
     * For example: param fullCommand = "\name Justin\age 24",
     * The value returned for key "\name" will be "Justin\age 24".
     * The value return for key "\age" will be EMPTY_STRING.
     *
     * @param fullCommand the entire command that the user supplied
     * @param key         the patient field, prepended with REGEX_BACKSLASH. This key is an enum.
     * @return the String that is between key and " \" delimiter
     */
    private String findValue(String fullCommand, String key) {
        String[] keyValue = fullCommand.split(key, LIMIT);

        try {
            DukeExceptions.doesKeyExist(keyValue);

            String valueString = keyValue[VALUE_STRING_INDEX];

            String delimiter = WHITESPACE + REGEX_BACKSLASH;
            String[] b = valueString.split(delimiter, LIMIT);

            String value = b[VALUE_INDEX];
            return value.trim();

        } catch (noKeyExistException e) {
            return BLANK_STRING;
        }
    }

    /**
     * This method returns a HashMap that matches the Patient fields to edit to the values to edit in.
     * The HashMap is guaranteed to contain the keys found in the enum PatientFieldKeys.
     * The values however will be determined by the user.
     *
     * @param fullCommand the user input that the user provided
     * @return a HashMap that matches the patient's fieldKey to value.
     *
     * @see PatientFieldKeys for the list of keys guaranteed to be in the HashMap
     * @see #findValue(String fullCommand ,String key) value returned by this method will be stored at key.
     */
    private Map<String, String> getPatientFields(String fullCommand) {
        Map<String, String> fieldsToChange = new HashMap<>();

        for (PatientFieldKeys pf : PatientFieldKeys.values()) {
            String field = pf.toString();
            String key = WHITESPACE + REGEX_BACKSLASH + field; // String key = "\key";
            String value = findValue(fullCommand, key);
            fieldsToChange.put(field, value);
            if(field.equals(ADD_PATIENT)) {
                Duke.indexNumber++;
                fieldsToChange.put(INDEX, Integer.toString(Duke.indexNumber));
            }
        }


        return fieldsToChange;
    }

    /**
     * This method returns the command object to be executed.
     * Throws an unknownCommandException for the caller to catch when user supplied an unknown command
     *
     * @param fullCommand the user input that the user provided
     * @return a command object to be executed
     * @throws unknownCommandException Throws custom duke exception to catch and print error message.
     */
    public Command parseCommand(String fullCommand) throws unknownCommandException {
        String commandAsString = getCommand(fullCommand);

        Command command;
        Map<String, String> fieldsToChange;
        switch (commandAsString) {
        case ADD_PATIENT :
            //fallthrough
        case EDIT_PATIENT :
        case DELETE_PATIENT:
            fieldsToChange = getPatientFields(fullCommand);
            command = getCommandObject(commandAsString, fieldsToChange);
            break;
        default :
            command = getCommandObject(commandAsString, null);
            break;
        }
        return command; //return a command object to @andyyy/@duccc
    }

    /**
     * This method returns the specific type of command object.
     * Throws an unknownCommandException for the caller to catch when user supplied an unknown command
     *
     * @param command the command that was specified
     * @param fieldsToChange the HashMap of what to add or edit
     * @return a specific command object that is specified by @param command.
     * @throws unknownCommandException Throws custom duke exception to catch and print error message.
     */
    private Command getCommandObject(String command, Map<String, String> fieldsToChange) throws unknownCommandException {
        switch (command) {
        case ADD_PATIENT:
            assert fieldsToChange != null;
            return new AddPatientCommand(fieldsToChange);
        case EDIT_PATIENT:
            assert fieldsToChange != null;
            return new UpdatePatientCommand(fieldsToChange);
        case DELETE_PATIENT:
            return new DeletePatientCommand(fieldsToChange);
        case LIST_PATIENT:
            return new ListPatientCommand();
        default:
            DukeExceptions.unknownCommand();
            return null;
        }
    }
}
