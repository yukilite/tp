package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListPatientCommandTest {

    private static final String EXPECTED_OUTPUT =
            "{[Name]: s;dlskd;l | [Age]: 23 | [Address]: Li | [Contact Number]: 121}" + System.lineSeparator() +
                    "{[Name]:   | [Age]: 15 | [Address]:   | [Contact Number]: 15454455}" + System.lineSeparator() +
                    "{[Name]: ewuioaiwoe | [Age]: 33 | [Address]: Lo | [Contact Number]: 1989}" +
                    System.lineSeparator() +
                    "{[Name]: aeiwae | [Age]: 13 | [Address]: to | [Contact Number]:  }" + System.lineSeparator() +
                    "{[Name]: LSDs | [Age]: -1 | [Address]: Lis | [Contact Number]: 12}" + System.lineSeparator();
    private static final String EMPTY = "";

    @Test
    void testListWithPatients() {
        Ui ui = null;
        Storage storage = new Storage();
        Patient newPatient1 = new Patient("s;dlskd;l", 23, "Li", "121");
        Patient newPatient2 = new Patient(" ", 15, " ", "15454455");
        Patient newPatient3 = new Patient("ewuioaiwoe", 33, "Lo", "1989");
        Patient newPatient4 = new Patient("aeiwae", 13,  "to", " ");
        Patient newPatient5 = new Patient("LSDs", -1, "Lis", "12");
        List<Patient> savedPatientList = new ArrayList<>();
        savedPatientList.add(newPatient1);
        savedPatientList.add(newPatient2);
        savedPatientList.add(newPatient3);
        savedPatientList.add(newPatient4);
        savedPatientList.add(newPatient5);
        PatientList patientList = new PatientList(savedPatientList);
        ListPatientCommand listPatientCommand = new ListPatientCommand();

        /** Reused from https://coderanch.com/t/587280/java/assertEquals-println **/
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        listPatientCommand.execute(ui,storage);
        assertEquals(EXPECTED_OUTPUT, outContent.toString());



    }

    @Test
    void testListWithoutPatients() {
        Ui ui = null;
        Storage storage = new Storage();

        List<Patient> savedPatientList = new ArrayList<>();

        PatientList patientList = new PatientList(savedPatientList);
        ListPatientCommand listPatientCommand = new ListPatientCommand();

        /** Reused from https://coderanch.com/t/587280/java/assertEquals-println **/
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        listPatientCommand.execute(ui,storage);
        assertEquals(EMPTY, outContent.toString());



    }
}