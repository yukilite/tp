package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.duke.command.UpdateCommand.*;

class UpdateCommandTest {

    //Test case 1
    @Test
    void execute_1() throws Exception{
        PatientList patientList = new PatientList();
        patientList.getPatientList().add(new Patient("peony", 33, "clementi road", "61234567"));
        patientList.getPatientList().add(new Patient("yoshino", 8, "shibuya", "13182371"));
        patientList.getPatientList().add(new Patient("kurumi", 15, "hokkaido", "31732913"));
        patientList.getPatientList().add(new Patient("ren", 17, "tokyo", "31093991"));
        patientList.getPatientList().add(new Patient("ren", 17, "tokyo", "31093991"));
        Map<String, String> fieldsToChange = new HashMap<>();
        Ui ui = new Ui();
        Storage storage = new Storage();
        fieldsToChange.put(PATIENT_INDEX, "3");
        fieldsToChange.put(PATIENT_NAME, "Joe Harris");
        fieldsToChange.put(AGE, "20");
        fieldsToChange.put(ADDRESS, "Jurong East");
        fieldsToChange.put(CONTACT_NUMBER, "8225 3819");
        Command command = new UpdateCommand(fieldsToChange);
        command.execute(ui,storage);
        assertEquals("{[Name]: Joe Harris | [Age]: 20 | [Address]: Jurong East | [Contact Number]: 8225 3819}",
                patientList.getPatientRecord(2).toString());
    }
/*
    //Test case 2
    @Test
    void execute_2() throws Exception{
        PatientList patientList = new PatientList();
        patientList.getPatientList().add(new Patient("peony", 33, "clementi road", "61234567"));
        patientList.getPatientList().add(new Patient("yoshino", 8, "shibuya", "13182371"));
        patientList.getPatientList().add(new Patient("kurumi", 15, "hokkaido", "31732913"));
        patientList.getPatientList().add(new Patient("ren", 17, "tokyo", "31093991"));
        patientList.getPatientList().add(new Patient("ren", 17, "tokyo", "31093991"));
        Map<String, String> fieldsToChange = new HashMap<>();
        Ui ui = new Ui();
        Storage storage = new Storage();
        fieldsToChange.put(PATIENT_INDEX, "3");
        fieldsToChange.put(PATIENT_NAME, null);
        fieldsToChange.put(AGE, null);
        fieldsToChange.put(ADDRESS, null);
        fieldsToChange.put(CONTACT_NUMBER, "8225 3819");
        Command command = new UpdateCommand(fieldsToChange);
        command.execute(ui,storage);
        assertEquals("{[Name]: kurumi | [Age]: 15 | [Address]: hokkaido | [Contact Number]: 8225 3819}",
                patientList.getPatientRecord(2).toString());
    }

 */
}