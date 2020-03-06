package seedu.duke.parser;

import seedu.duke.command.Command;
import seedu.duke.enums.Commands;
import seedu.duke.enums.PatientFields;
import seedu.duke.record.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static final String REGEX_SPACE = " ";
    public static final int COMMAND_INDEX = 0;
    private static final int LIMIT = 2;

    public Parser() {

    }

    private String getCommand(String fullCommand) {
        String[] splits = fullCommand.split(REGEX_SPACE, LIMIT);
        return splits[COMMAND_INDEX].trim();
    }

    private String findValue(String fullCommand, String key) {
        String[] keyValue = fullCommand.split(key);
    }

    private HashMap<String, String> getPatientFields(String fullCommand) {
        Map<String, String> fieldsToChange = new HashMap<>();
        for (PatientFields pf : PatientFields.values()) {
            String key = pf.toString();
            String value = findValue(fullCommand, key);
        }
    }

    public Command parseCommand(String fullCommand) {
        String commandAsString = getCommand(fullCommand);
        Map<String, String> fieldsToChange = getPatientFields(fullCommand);
        Command command = Commands.getCommandObject(commandAsString, fullCommand);
        return null; //todo
    }

}
