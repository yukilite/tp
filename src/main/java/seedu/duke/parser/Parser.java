package seedu.duke.parser;

import seedu.duke.Duke;

import seedu.duke.command.Command;

import seedu.duke.command.AddAppointmentCommand;
import seedu.duke.command.DeleteAppointmentCommand;
import seedu.duke.command.ListAppointmentCommand;
import seedu.duke.command.UpdateAppointmentCommand;

import seedu.duke.command.AddPatientCommand;
import seedu.duke.command.DeletePatientCommand;
import seedu.duke.command.ListPatientCommand;
import seedu.duke.command.UpdatePatientCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.HelpCommand;

import seedu.duke.exceptions.DukeExceptions;
import seedu.duke.exceptions.DescriptionIsEmptyException;
import seedu.duke.exceptions.IndexNotIntegerException;
import seedu.duke.exceptions.InvalidIndexException;
import seedu.duke.exceptions.NoKeyExistException;
import seedu.duke.exceptions.UnknownCommandException;

import java.util.HashMap;
import java.util.Map;

import seedu.duke.enums.AppointmentFieldKeys;
import seedu.duke.enums.PatientFieldKeys;

public class Parser {
    private static final int COMMAND_INDEX = 0;
    private static final int LIMIT = 2;
    private static final int VALUE_INDEX = 0;
    private static final int VALUE_STRING_INDEX = 1;


    private static final String REGEX_BACKSLASH = "\\\\";
    private static final String BLANK_STRING = "";
    private static final String WHITESPACE = " ";
    private static final String INDEX = "index";

    private static final String HELP_COMMAND = "help";
    private static final String EXIT_COMMAND = "exit";

    private static final String ADD_PATIENT = "addp";
    private static final String EDIT_PATIENT = "editp";
    private static final String DELETE_PATIENT = "deletep";
    private static final String LIST_PATIENT = "listp";

    private static final String ADD_APPOINTMENT = "adda";
    private static final String EDIT_APPOINTMENT = "edita";
    private static final String DELETE_APPOINTMENT = "deletea";
    private static final String LIST_APPOINTMENT = "lista";

    /**
     * This methods returns the command from the user input string.
     *
     * @param fullCommand the user input string.
     * @return the actual command to execute.
     */
    private String[] getCommand(String fullCommand) {
        String[] splits = fullCommand.split(" " + REGEX_BACKSLASH, LIMIT);
        return splits;
    }

    /**
     * Returns strictly the String that is between the fieldKey and " \" delimiter.
     *
     * @param fullCommand the entire command that the user supplied.
     * @param key the patient field, prepended with REGEX_BACKSLASH.
     * @return the String that is between key and " \" delimiter.
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

        } catch (NoKeyExistException e) {
            return BLANK_STRING;
        }
    }

    /**
     * Returns a HashMap that matches the Patient fields to edit to the values to edit in.
     * The HashMap is guaranteed to contain the keys found in the enum PatientFieldKeys.
     * The values however will be determined by the user.
     *
     * @param fullCommand the user input that the user provided.
     * @return a HashMap that matches the patient's fieldKey to value.
     * @see PatientFieldKeys for the list of keys guaranteed to be in the HashMap.
     * @see #findValue(String fullCommand, String key) value returned by this method will be stored at key.
     */
    private Map<String, String> getPatientFields(String fullCommand) {
        Map<String, String> patientFieldsToChange = new HashMap<>();

        for (PatientFieldKeys pf : PatientFieldKeys.values()) {
            String field = pf.toString();
            String key = WHITESPACE + REGEX_BACKSLASH + field;
            String value = findValue(fullCommand, key);
            patientFieldsToChange.put(field, value);
        }
        return patientFieldsToChange;
    }

    /**
     * Returns a HashMap that matches the Appointment fields to edit to the values to edit in.
     * The HashMap is guaranteed to contain the keys found in the enum AppointmentFieldKeys.
     * The values however will be determined by the user. If not provided, EMPTY_STRING will be stored
     *
     * @param fullCommand the user input that the user provided
     * @return a HashMap that matches the appointment's fieldKey to value.
     * @see AppointmentFieldKeys
     * @see #findValue(String fullcommand, String key) value returned by this method will be stored at key.
     */
    private Map<String, String> getAppointmentFields(String fullCommand) {
        Map<String, String> appointmentFieldsToChange = new HashMap<>();

        for (AppointmentFieldKeys af : AppointmentFieldKeys.values()) {
            String field = af.toString();
            String key = WHITESPACE + REGEX_BACKSLASH + field;
            String value = findValue(fullCommand, key);
            appointmentFieldsToChange.put(field, value);
        }
        return appointmentFieldsToChange;
    }

    /**
     * Returns the specific type of command object.
     * Throws an UnknownCommandException for the caller to catch when user supplied an unknown command.
     * Throws InvalidIndexError when the index supplied for edit and delete commands are invalid (alphabets, <= 0).
     *
     * @param command        the command that was specified.
     * @param fieldsToChange the HashMap of what to add or edit.
     * @return a specific command object that is specified by @param command.
     * @throws UnknownCommandException Throws custom duke exception to catch and print error message.
     * @throws InvalidIndexException       Throws a custom duke exception to catch and print error message.
     */
    private Command getCommandObject(String command, Map<String, String> fieldsToChange) throws UnknownCommandException,
            InvalidIndexException, IndexNotIntegerException {
        switch (command) {
        case ADD_PATIENT:
            Duke.patientIndexNumber++;
            fieldsToChange.put(INDEX, Integer.toString(Duke.patientIndexNumber));
            return new AddPatientCommand(fieldsToChange);

        case EDIT_PATIENT:
            DukeExceptions.checkIndexValidity(fieldsToChange.get(INDEX), command);
            return new UpdatePatientCommand(fieldsToChange);

        case DELETE_PATIENT:
            DukeExceptions.checkIndexValidity(fieldsToChange.get(INDEX), command);
            return new DeletePatientCommand(fieldsToChange);

        case LIST_PATIENT:
            return new ListPatientCommand();

        case ADD_APPOINTMENT:
            Duke.appointmentIndexNumber++;
            fieldsToChange.put(INDEX, Integer.toString(Duke.patientIndexNumber));
            return new AddAppointmentCommand(fieldsToChange);

        case EDIT_APPOINTMENT:
            DukeExceptions.checkIndexValidity(fieldsToChange.get(INDEX), command);
            return new UpdateAppointmentCommand(fieldsToChange);

        case DELETE_APPOINTMENT:
            DukeExceptions.checkIndexValidity(fieldsToChange.get(INDEX), command);
            return new DeleteAppointmentCommand(fieldsToChange);

        case LIST_APPOINTMENT:
            return new ListAppointmentCommand();

        case HELP_COMMAND:
            return new HelpCommand();

        case EXIT_COMMAND:
            return new ExitCommand();

        default:
            DukeExceptions.throwUnknownCommand();
            return null;
        }
    }

    /**
     * Returns the command object to be executed.
     * Throws an UnknownCommandException for the caller to catch when user supplied an unknown command.
     *
     * @param fullCommand the user input that the user provided.
     * @return a command object to be executed.
     * @throws UnknownCommandException Throws custom duke exception to catch and print error message.
     */
    public Command parseCommand(String fullCommand) throws UnknownCommandException, DescriptionIsEmptyException,
            InvalidIndexException, IndexNotIntegerException {
        String[] commandParsed = getCommand(fullCommand);
        String commandAsString = commandParsed[COMMAND_INDEX].trim();

        Command command;
        Map<String, String> fieldsToChange;
        switch (commandAsString) {
        case ADD_PATIENT:
            //fallthrough
        case EDIT_PATIENT:
            //fallthrough
        case DELETE_PATIENT:
            DukeExceptions.isCommandDescriptionEmpty(commandParsed);
            fieldsToChange = getPatientFields(fullCommand);
            command = getCommandObject(commandAsString, fieldsToChange);
            break;

        case ADD_APPOINTMENT:
            //fallthrough
        case EDIT_APPOINTMENT:
            //fallthrough
        case DELETE_APPOINTMENT:
            DukeExceptions.isCommandDescriptionEmpty(commandParsed);
            fieldsToChange = getAppointmentFields(fullCommand);
            command = getCommandObject(commandAsString, fieldsToChange);
            break;

        default:
            command = getCommandObject(commandAsString, null);
            break;
        }
        return command;
    }
}
