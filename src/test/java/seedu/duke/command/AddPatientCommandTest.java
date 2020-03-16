package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class AddPatientCommandTest {

    Patient newPatient1 = new Patient("s;dlskd;l", 23, "Li", "121");
    Patient newPatient2 = new Patient(" ", 15, " ", "15454455");
    Patient newPatient3 = new Patient("ewuioaiwoe", 33, "Lo", "1989");
    Patient newPatient4 = new Patient("aeiwae", 13, "to", " ");
    Patient newPatient5 = new Patient("LSDs", -1, "Lis", "12");


    @Test
    void testNormalInput() {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", "asdasd");
        tempMap.put("age", "12");
        tempMap.put("address", "asdasd");
        tempMap.put("phone", "asdsad");
        try {
            AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
            int number = 12;
            assertEquals(number, addPatientCommand.getAge());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testEmptyString() {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", "");
        tempMap.put("age", "");
        tempMap.put("address", "");
        tempMap.put("phone", "");
        try {
            AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testAge() {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", "");
        tempMap.put("age", "");
        tempMap.put("address", "");
        tempMap.put("phone", "");
        try {
            AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
            int number = -1;
            assertEquals(number, addPatientCommand.getAge());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testNonIntAge() {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", "asdsad");
        tempMap.put("age", "asdsada");
        tempMap.put("address", "asdsds");
        tempMap.put("phone", "asdsadsad");
        try {
            AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
            int number = -1;
            assertEquals(number, addPatientCommand.getAge());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testEmptyMap() {
        Map<String, String> tempMap = new HashMap<>();
        try {
            AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /*
    @Test
    void testAddNormalString() throws IOException {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", "asd");
        tempMap.put("age", "23");
        tempMap.put("address", "asdsds");
        tempMap.put("phone", "asdsadsad");
        Patient newPatient1 = new Patient("s;dlskd;l", 23, "Li", "121");
        Patient newPatient2 = new Patient(" ", 15, " ", "15454455");
        Patient newPatient3 = new Patient("ewuioaiwoe", 33, "Lo", "1989");
        Patient newPatient4 = new Patient("aeiwae", 13, "to", " ");
        Patient newPatient5 = new Patient("LSDs", -1, "Lis", "12");
        List<Patient> savedPatientList = new ArrayList<>();
        savedPatientList.add(newPatient1);
        savedPatientList.add(newPatient2);
        savedPatientList.add(newPatient3);
        savedPatientList.add(newPatient4);
        savedPatientList.add(newPatient5);
        PatientList patientList = new PatientList(savedPatientList);
        Ui ui = null;
        Storage storage = new Storage();
        AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
        addPatientCommand.execute(ui, storage);
        Patient temppatient = patientList.getPatientList().get(patientList.getPatientList().size() - 1);
        Patient newPatient = new Patient("asd", 23, "asdsds", "asdsadsad");
        assertEquals(temppatient.getName(), newPatient.getName());
        assertEquals(temppatient.getAge(), newPatient.getAge());
        assertEquals(temppatient.getAddress(), newPatient.getAddress());
        assertEquals(temppatient.getContactNumber(), newPatient.getContactNumber());
    }
     */

    /*
    @Test
    void testAddEmptyString() throws IOException {

        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", "");
        tempMap.put("age", "");
        tempMap.put("address", "");
        tempMap.put("phone", "");
        Patient newPatient1 = new Patient("s;dlskd;l", 23, "Li", "121");
        Patient newPatient2 = new Patient(" ", 15, " ", "15454455");
        Patient newPatient3 = new Patient("ewuioaiwoe", 33, "Lo", "1989");
        Patient newPatient4 = new Patient("aeiwae", 13, "to", " ");
        Patient newPatient5 = new Patient("LSDs", -1, "Lis", "12");
        List<Patient> savedPatientList = new ArrayList<>();
        savedPatientList.add(newPatient1);
        savedPatientList.add(newPatient2);
        savedPatientList.add(newPatient3);
        savedPatientList.add(newPatient4);
        savedPatientList.add(newPatient5);
        PatientList patientList = new PatientList(savedPatientList);
        Ui ui = null;
        Storage storage = new Storage();
        AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
        addPatientCommand.execute(ui, storage);
        Patient temppatient = patientList.getPatientList().get(patientList.getPatientList().size() - 1);
        Patient newPatient = new Patient("", -1, "", "");
        assertEquals(temppatient.getName(), newPatient.getName());
        assertEquals(temppatient.getAge(), newPatient.getAge());
        assertEquals(temppatient.getAddress(), newPatient.getAddress());
        assertEquals(temppatient.getContactNumber(), newPatient.getContactNumber());
    }
     */
}