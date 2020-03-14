package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.command.UpdateCommand;
import seedu.duke.enums.PatientFieldKeys;
import seedu.duke.exceptions.unknownCommandException;
import seedu.duke.record.Patient;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private static Parser p = new Parser();

    @Test
    void testParseCommand_unknownCommand_exceptionCaught() {
        String userInputWithUnknownCommand = "factorial 100000";
        try {
            p.parseCommand(userInputWithUnknownCommand);
        } catch (Exception e) {
            assertEquals("unknownCommandException", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_addPatientCommand_isAddCommand() {
        String addPatientUserInput1 = "addp \\name \\age \\address";
        String addPatientUserInput2 = "addp                        \\unknown \\age \\name \\12333";

        try {
            Command type1 = p.parseCommand(addPatientUserInput1);
            Command type2 = p.parseCommand(addPatientUserInput2);
            assertTrue(type1 instanceof AddCommand);
            assertTrue(type2 instanceof AddCommand);
        } catch (Exception e) {
            fail("Should not have thrown any exceptions");
        }
    }

    /* checks the return type of command. It should not be an AddCommand. */
    @Test
    void testParseCommand_addPatientCommand_isNotAddCommand() {
        String addPatientUserInput1 = "deletep \\index 3";
        String addPatientUserInput2 = "editp \\index -100 \\name Justin \\age 23 \\address Pasir Ris";
        String addPatientUserInput3 = "listp";

        try {
            Command type1 = p.parseCommand(addPatientUserInput1);
            Command type2 = p.parseCommand(addPatientUserInput2);
            Command type3 = p.parseCommand(addPatientUserInput3);

            assertFalse(type1 instanceof AddCommand);
            assertFalse(type2 instanceof AddCommand);
            assertFalse(type3 instanceof AddCommand);

        } catch (Exception e) {
            fail("Should not have thrown any exceptions");
        }
    }

    @Test
    void tetParseCommand_editPatientCommand_isEditCommand() {
        String editPatientUserInput1 = "editp \\index 5 \\";
        String editPatientUserInput2 = "editp       \\index 3 \\name \\age 23 \\address pasir ris";
        String editPatientUserInput3 = "         editp  \\index 4      \\\\\\\\\\";

        try {
            Command type1 = p.parseCommand(editPatientUserInput1);
            Command type2 = p.parseCommand(editPatientUserInput2);
            Command type3 = p.parseCommand(editPatientUserInput3);

            assertTrue(type1 instanceof UpdateCommand);
            assertTrue(type2 instanceof UpdateCommand);
            assertTrue(type3 instanceof UpdateCommand);

        } catch (Exception e) {
            fail("Should not have thrown any exception");
        }
    }

    @Test
    void testParseCommand_editPatientCommand_isNotEditCommand() {
        String editPatientUserInput1 = "deletep \\index 3";
        String editPatientUserInput2 = "addp                        \\unknown \\age \\name \\12333";
        String editPatientUserInput3 = "listp";

        try {
            Command type1 = p.parseCommand(editPatientUserInput1);
            Command type2 = p.parseCommand(editPatientUserInput2);
            Command type3 = p.parseCommand(editPatientUserInput3);

            assertFalse(type1 instanceof UpdateCommand);
            assertFalse(type2 instanceof UpdateCommand);
            assertFalse(type3 instanceof UpdateCommand);

        } catch (Exception e) {
            fail("Should not have thrown any exceptions");
        }
    }

    @Test
    void testParseCommand_deletePatientCommand_isDeleteCommand() {
        String deletePatientUserInput1 = "deletep \\index 3";
        String deletePatientUserInput2 = "           deletep";
        String deletePatientUserInput3 = "";
    }
}