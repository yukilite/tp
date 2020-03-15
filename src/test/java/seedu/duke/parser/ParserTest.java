package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.command.*;
import seedu.duke.command.AddPatientCommand;
import seedu.duke.command.DeletePatientCommand;
import seedu.duke.command.ListPatientCommand;
import seedu.duke.command.UpdatePatientCommand;
import seedu.duke.exceptions.UnknownCommandException;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private static Parser p = new Parser();

    @Test
    void testParseCommand_unknownCommand_exceptionCaught() {
        String userInputWithUnknownCommand = "factorial 100000";
        try {
            p.parseCommand(userInputWithUnknownCommand);
        } catch (Exception e) {
            assertEquals("Unknown Command", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_addPatientCommand_isAddCommand() {
        String addPatientUserInput1 = "addp \\name \\age \\address";
        String addPatientUserInput2 = "addp                        \\unknown \\age \\name \\12333";

        try {
            Command type1 = p.parseCommand(addPatientUserInput1);
            Command type2 = p.parseCommand(addPatientUserInput2);

            assertTrue(type1 instanceof AddPatientCommand);
            assertTrue(type2 instanceof AddPatientCommand);
        } catch (Exception e) {
            fail("Should not have thrown any exceptions");
        }
    }

    @Test
    void testParseCommand_addPatientCommand_isNotAddCommand() {
        String addPatientUserInput1 = "deletep \\index 3";
        String addPatientUserInput2 = "edip \\index -100 \\name Justin \\age 23 \\address Pasir Ris";
        String addPatientUserInput3 = "listp";

        try {
            Command type1 = p.parseCommand(addPatientUserInput1);
            Command type2 = p.parseCommand(addPatientUserInput2);
            Command type3 = p.parseCommand(addPatientUserInput3);

            assertFalse(type1 instanceof AddPatientCommand);
            assertFalse(type2 instanceof AddPatientCommand);
            assertFalse(type3 instanceof AddPatientCommand);

        } catch (Exception e) {
            assertEquals("Unknown Command", e.getLocalizedMessage());
        }
    }

    @Test
    void tetParseCommand_editPatientCommand_isEditCommand() {
        String editPatientUserInput1 = "editp \\index 5 \\";
        String editPatientUserInput2 = "editp       \\index 3 \\name \\age 23 \\address pasir ris";
        String editPatientUserInput3 = "         editp  \\index 4      \\\\\\\\\\";

        PatientList stub = new PatientList();
        Patient newPatient = new Patient("1", 1, "1", "1");
        for (int i = 0; i < 10; i += 1) {
            PatientList.getPatientList().add(newPatient);
        }

        try {
            Command type1 = p.parseCommand(editPatientUserInput1);
            Command type2 = p.parseCommand(editPatientUserInput2);
            Command type3 = p.parseCommand(editPatientUserInput3);

            assertTrue(type1 instanceof UpdatePatientCommand);
            assertTrue(type2 instanceof UpdatePatientCommand);
            assertTrue(type3 instanceof UpdatePatientCommand);

        } catch (Exception e) {
            fail("Should not have thrown any exception");
        }
    }

    @Test
    void testParseCommand_editPatientCommand_isNotEditCommand() {
        String editPatientUserInput1 = "adda \\index 3";
        String editPatientUserInput2 = "addp                        \\unknown \\age \\name \\12333";
        String editPatientUserInput3 = "list";

        try {
            Command type1 = p.parseCommand(editPatientUserInput1);
            Command type2 = p.parseCommand(editPatientUserInput2);
            Command type3 = p.parseCommand(editPatientUserInput3);

            assertFalse(type1 instanceof UpdatePatientCommand);
            assertFalse(type2 instanceof UpdatePatientCommand);
            assertFalse(type3 instanceof UpdatePatientCommand);

        } catch (Exception e) {
            assertEquals("Unknown Command", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_deletePatientCommand_isDeleteCommand() {
        String deletePatientUserInput1 = "         deletep  \\index 4      \\\\\\\\\\";
        String deletePatientUserInput2 = "           deletep \\index 10";
        String deletePatientUserInput3 = "deletep               \\index 1";

        PatientList stub = new PatientList();
        Patient newPatient = new Patient("1", 1, "1", "1");
        for (int i = 0; i < 10; i += 1) {
            PatientList.getPatientList().add(newPatient);
        }

        try {
            Command type1 = p.parseCommand(deletePatientUserInput1);
            Command type2 = p.parseCommand(deletePatientUserInput2);
            Command type3 = p.parseCommand(deletePatientUserInput3);

            assertTrue(type1 instanceof DeletePatientCommand);
            assertTrue(type2 instanceof DeletePatientCommand);
            assertTrue(type3 instanceof DeletePatientCommand);

        } catch (Exception e) {
            fail("Should not have thrown any exceptions");
        }
    }

    @Test
    void testParseCommand_deletePatientCommand_isNotDeleteCommand() {
        String deletePatientUserInput1 = "addp                        \\unknown \\age \\name \\12333";
        String deletePatientUserInput2 = "           listp";
        String deletePatientUserInput3 = "edipt               \\index 0";

        try {
            Command type1 = p.parseCommand(deletePatientUserInput1);
            Command type2 = p.parseCommand(deletePatientUserInput2);
            Command type3 = p.parseCommand(deletePatientUserInput3);

            assertFalse(type1 instanceof DeletePatientCommand);
            assertFalse(type2 instanceof DeletePatientCommand);
            assertFalse(type3 instanceof DeletePatientCommand);

        } catch (Exception e) {
            assertEquals("Unknown Command", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_listPatientCommand() {
        String listPatientUserInput1 = "listp";
        String listPatientUserInput2 = "          listp                  ";
        String listPatientUserInput3 = "listp \\name Justin";
        String listPatientUserInput4 = "list";
        String listPatientUserInput5 = "addp \\name Justin \\address";
        String listPatientUserInput6 = "list\\";

        try {
            Command type1 = p.parseCommand(listPatientUserInput1);
            Command type2 = p.parseCommand(listPatientUserInput2);
            Command type3 = p.parseCommand(listPatientUserInput3);
            Command type4 = p.parseCommand(listPatientUserInput4);
            Command type5 = p.parseCommand(listPatientUserInput5);
            Command type6 = p.parseCommand(listPatientUserInput6);

            assertTrue(type1 instanceof ListPatientCommand);
            assertTrue(type2 instanceof ListPatientCommand);
            assertTrue(type3 instanceof ListPatientCommand);

            assertFalse(type4 instanceof DeletePatientCommand);
            assertFalse(type5 instanceof DeletePatientCommand);
            assertFalse(type6 instanceof DeletePatientCommand);

        } catch (Exception e) {
            assertEquals("Unknown Command", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_helpCommand() {
        String helpUserInput1 = "help";
        String helpUserInput2 = "       help";
        String helpUserInput3 = "help          \\name Justin \\age 23 \\address pasir ris";
        String helpUserInput4 = "elp";
        String helpUserInput5 = "addp \\name Justin \\age 23 \\address pasir ris \\phone 999";
        String helpUserInput6 ="editp \\sam \\age 99 \\address sentosa cove";

        try {
            Command type1 = p.parseCommand(helpUserInput1);
            Command type2 = p.parseCommand(helpUserInput2);
            Command type3 = p.parseCommand(helpUserInput3);
            Command type4 = p.parseCommand(helpUserInput4);
            Command type5 = p.parseCommand(helpUserInput5);
            Command type6 = p.parseCommand(helpUserInput6);

            assertTrue(type1 instanceof HelpCommand);
            assertTrue(type2 instanceof HelpCommand);
            assertTrue(type3 instanceof HelpCommand);

            assertFalse(type4 instanceof HelpCommand);
            assertFalse(type5 instanceof HelpCommand);
            assertFalse(type6 instanceof HelpCommand);

        } catch (Exception e) {
            assertEquals("Unknown Command", e.getLocalizedMessage());
        }
    }

}