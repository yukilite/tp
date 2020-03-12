package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.duke.command.UpdatePatientCommand.*;

class DeletePatientCommandTest {

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
        Command command = new DeletePatientCommand(fieldsToChange);
        command.execute(ui,storage);
        assertEquals(4, patientList.getTotalPatients());
        assertEquals("{[Name]: peony | [Age]: 33 | [Address]: clementi road | [Contact Number]: 61234567}",
                patientList.getPatientRecord(0).toString());
        assertEquals("{[Name]: yoshino | [Age]: 8 | [Address]: shibuya | [Contact Number]: 13182371}",
                patientList.getPatientRecord(1).toString());
        assertEquals("{[Name]: ren | [Age]: 17 | [Address]: tokyo | [Contact Number]: 31093991}",
                patientList.getPatientRecord(2).toString());
        assertEquals("{[Name]: ren | [Age]: 17 | [Address]: tokyo | [Contact Number]: 31093991}",
                patientList.getPatientRecord(3).toString());
    }
}