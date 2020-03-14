package seedu.duke.command;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddPatientCommandTest {

    @Test
    void testNormalInput() {
        Map<String,String> tempMap = new HashMap<>();
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
        Map<String,String> tempMap = new HashMap<>();
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
        Map<String,String> tempMap = new HashMap<>();
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
        Map<String,String> tempMap = new HashMap<>();
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
        Map<String,String> tempMap = new HashMap<>();
        try {
            AddPatientCommand addPatientCommand = new AddPatientCommand(tempMap);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testAddNormalString() {
        int ui = 1;
        int storage = 1;
        Map<String,String> tempMap = AddPatientCommandStub.generateMap(1);
        AddPatientCommandStub addCommand = new AddPatientCommandStub(tempMap);
        addCommand.execute(ui,storage);
        PatientStub temppatient = PatientListStub.getPatientList().get(PatientListStub.getTotalPatients() - 1);
        PatientStub newPatient = new PatientStub("asd", 23,"asdsds","asdsadsad");
        assertEquals(temppatient.getName(),newPatient.getName());
        assertEquals(temppatient.getAge(),newPatient.getAge());
        assertEquals(temppatient.getAddress(),newPatient.getAddress());
        assertEquals(temppatient.getContactNumber(),newPatient.getContactNumber());
    }

    @Test
    void testAddEmptyString()  {
        int ui = 1;
        int storage = 1;
        Map<String,String> tempMap = AddPatientCommandStub.generateMap(2);
        AddPatientCommandStub addCommand = new AddPatientCommandStub(tempMap);
        addCommand.execute(ui,storage);
        PatientStub temppatient = PatientListStub.getPatientList().get(PatientListStub.getTotalPatients() - 1);
        PatientStub newPatient = new PatientStub("", -1,"","");
        assertEquals(temppatient.getName(),newPatient.getName());
        assertEquals(temppatient.getAge(),newPatient.getAge());
        assertEquals(temppatient.getAddress(),newPatient.getAddress());
        assertEquals(temppatient.getContactNumber(),newPatient.getContactNumber());
    }

}