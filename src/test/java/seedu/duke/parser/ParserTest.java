package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddPatientCommand;
import seedu.duke.command.Command;
import seedu.duke.command.DeletePatientCommand;
import seedu.duke.command.EditPatientCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ListPatientCommand;
import seedu.duke.exceptions.DescriptionIsEmptyException;
import seedu.duke.exceptions.IndexNotIntegerException;
import seedu.duke.exceptions.InvalidIndexException;
import seedu.duke.exceptions.NoFieldCommandException;
import seedu.duke.exceptions.UnknownCommandException;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ParserTest {

    private static Parser p = new Parser();

    @Test
    void testParseCommand_unknownCommand_exceptionCaught() {
        String userInputWithUnknownCommand = "factorial 100000";
        try {
            p.parseCommand(userInputWithUnknownCommand);
        } catch (Exception | UnknownCommandException e) {
            assertEquals("Unknown command", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_addPatientCommand_isAddCommand() {
        String addPatientUserInput1 = "addp \\name Justin \\age \\address";
        String addPatientUserInput2 = "addp                        \\unknown \\age 23 \\name \\12333";

        try {
            Command type1 = p.parseCommand(addPatientUserInput1);
            Command type2 = p.parseCommand(addPatientUserInput2);

            assertTrue(type1 instanceof AddPatientCommand);
            assertTrue(type2 instanceof AddPatientCommand);
        } catch (Exception | UnknownCommandException e) {
            assertTrue(true);

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

        } catch (Exception | UnknownCommandException e) {
            assertEquals("Unknown command", e.getLocalizedMessage());
        }
    }

    /*
    @Test
    void tetParseCommand_editPatientCommand_isEditCommand() {
        String editPatientUserInput1 = "editp \\index 5 \\name Himiko";
        String editPatientUserInput2 = "editp       \\index 3 \\name \\age 23 \\address pasir ris";
        String editPatientUserInput3 = "         editp  \\index 4 \\phone 97283449";

        PatientList stub = new PatientList();
        Patient newPatient = new Patient("1", 1, "1", "1",1);
        for (int i = 0; i < 10; i += 1) {
            PatientList.getPatientList().add(newPatient);
        }

        try {
            Command type1 = p.parseCommand(editPatientUserInput1);
            Command type2 = p.parseCommand(editPatientUserInput2);
            Command type3 = p.parseCommand(editPatientUserInput3);

            assertTrue(type1 instanceof EditPatientCommand);
            assertTrue(type2 instanceof EditPatientCommand);
            assertTrue(type3 instanceof EditPatientCommand);

        } catch (Exception | UnknownCommandException e) {
            fail("Should not have thrown any exception");
        }
    }
    */

    @Test
    void testParseCommand_editPatientCommand_isNotEditCommand() {
        String editPatientUserInput1 = "adda \\index 3";
        String editPatientUserInput2 = "addp                        \\unknown \\age \\name \\12333";
        String editPatientUserInput3 = "list";

        try {
            Command type1 = p.parseCommand(editPatientUserInput1);
            Command type2 = p.parseCommand(editPatientUserInput2);
            Command type3 = p.parseCommand(editPatientUserInput3);

            assertFalse(type1 instanceof EditPatientCommand);
            assertFalse(type2 instanceof EditPatientCommand);
            assertFalse(type3 instanceof EditPatientCommand);

        } catch (UnknownCommandException e) {
            assertEquals("Unknown command", e.getLocalizedMessage());
        } catch (NoFieldCommandException e) {
            assertEquals("Please ensure that at least one field for adda is provided", e.getLocalizedMessage());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testParseCommand_deletePatientCommand_isDeleteCommand() {
        String deletePatientUserInput1 = "         deletep  \\index 4      \\\\\\\\\\";
        String deletePatientUserInput2 = "           deletep \\index 10";
        String deletePatientUserInput3 = "deletep               \\index 1";

        PatientList stub = new PatientList();
        Patient newPatient = new Patient("1", 1, "1", "1", 1);
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

        } catch (Exception | UnknownCommandException e) {
            fail("Should not have thrown any exceptions");
        }
    }

    @Test
    void testParseCommand_deletePatientCommand_isNotDeleteCommand() {
        String deletePatientUserInput1 = "addp                        \\unknown \\age 23 \\name \\12333";
        String deletePatientUserInput2 = "           listp";
        String deletePatientUserInput3 = "edipt               \\index 0";

        try {
            Command type1 = p.parseCommand(deletePatientUserInput1);
            Command type2 = p.parseCommand(deletePatientUserInput2);
            Command type3 = p.parseCommand(deletePatientUserInput3);

            assertFalse(type1 instanceof DeletePatientCommand);
            assertFalse(type2 instanceof DeletePatientCommand);
            assertFalse(type3 instanceof DeletePatientCommand);

        } catch (Exception | UnknownCommandException e) {
            assertEquals(
                    "Name to be added/edited should contain spaces optionally and alphabetic "
                            + "characters with length of between 1 and 64",
                    e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_listPatientCommand() {
        final String listPatientUserInput1 = "listp";
        final String listPatientUserInput2 = "          listp                  ";
        final String listPatientUserInput3 = "listp \\name Justin";
        final String listPatientUserInput4 = "list";
        final String listPatientUserInput5 = "addp \\name Justin \\address";
        final String listPatientUserInput6 = "list\\";

        try {
            Command type1 = p.parseCommand(listPatientUserInput1);
            assertTrue(type1 instanceof ListPatientCommand);

            Command type2 = p.parseCommand(listPatientUserInput2);
            assertTrue(type2 instanceof ListPatientCommand);

            Command type3 = p.parseCommand(listPatientUserInput3);
            assertTrue(type3 instanceof ListPatientCommand);

            Command type4 = p.parseCommand(listPatientUserInput4);
            assertFalse(type4 instanceof DeletePatientCommand);

            Command type5 = p.parseCommand(listPatientUserInput5);
            assertFalse(type5 instanceof DeletePatientCommand);

            Command type6 = p.parseCommand(listPatientUserInput6);
            assertFalse(type6 instanceof DeletePatientCommand);

        } catch (Exception | UnknownCommandException e) {
            assertEquals("Unknown command", e.getLocalizedMessage());
        }
    }

    @Test
    void testParseCommand_helpCommand() {
        final String helpUserInput1 = "help";
        final String helpUserInput2 = "       help";
        final String helpUserInput3 = "help          \\name Justin \\age 23 \\address pasir ris";
        final String helpUserInput4 = "elp";
        final String helpUserInput5 = "addp \\name Justin \\age 23 \\address pasir ris \\phone 999";
        final String helpUserInput6 = "editp \\sam \\age 99 \\address sentosa cove";

        try {
            Command type1 = p.parseCommand(helpUserInput1);
            assertTrue(type1 instanceof HelpCommand);

            Command type2 = p.parseCommand(helpUserInput2);
            assertTrue(type2 instanceof HelpCommand);

            Command type3 = p.parseCommand(helpUserInput3);
            assertTrue(type3 instanceof HelpCommand);

            Command type4 = p.parseCommand(helpUserInput4);
            assertFalse(type4 instanceof HelpCommand);

            Command type5 = p.parseCommand(helpUserInput5);
            assertFalse(type5 instanceof HelpCommand);

            Command type6 = p.parseCommand(helpUserInput6);
            assertFalse(type6 instanceof HelpCommand);

        } catch (Exception | UnknownCommandException e) {
            assertEquals("Unknown command", e.getLocalizedMessage());
        }
    }

}