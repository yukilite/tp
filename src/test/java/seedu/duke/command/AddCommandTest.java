package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    Patient newPatient1 = new Patient("s;dlskd;l", 23, "Li", "121");
    Patient newPatient2 = new Patient(" ", 15, " ", "15454455");
    Patient newPatient3 = new Patient("ewuioaiwoe", 33, "Lo", "1989");
    Patient newPatient4 = new Patient("aeiwae", 13,  "to", " ");
    Patient newPatient5 = new Patient("LSDs", -1, "Lis", "12");


    @Test
    void testNormalInput() {
        Map<String,String> tempMap = new HashMap<>();
        tempMap.put("name", "asdasd");
        tempMap.put("age", "12");
        tempMap.put("address", "asdasd");
        tempMap.put("phone", "asdsad");
        try {
            AddCommand addCommand = new AddCommand(tempMap);
            int number = 12;
            assertEquals(number, addCommand.getAge());
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
            AddCommand addCommand = new AddCommand(tempMap);
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
            AddCommand addCommand = new AddCommand(tempMap);
            int number = -1;
            assertEquals(number, addCommand.getAge());
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
            AddCommand addCommand = new AddCommand(tempMap);
            int number = -1;
            assertEquals(number, addCommand.getAge());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testEmptyMap() {
        Map<String,String> tempMap = new HashMap<>();
        try {
            AddCommand addCommand = new AddCommand(tempMap);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testAddNormalString() throws IOException {
        Ui ui = null;
        Storage storage = new Storage();
        Map<String,String> tempMap = new HashMap<>();
        tempMap.put("name", "asd");
        tempMap.put("age", "23");
        tempMap.put("address", "asdsds");
        tempMap.put("phone", "asdsadsad");
        AddCommand addCommand = new AddCommand(tempMap);
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
        addCommand.execute(ui,storage);
        Patient temppatient = patientList.getPatientList().get(patientList.getPatientList().size() - 1);
        Patient newPatient = new Patient("asd", 23,"asdsds","asdsadsad");
        assertEquals(temppatient.getName(),newPatient.getName());
        assertEquals(temppatient.getAge(),newPatient.getAge());
        assertEquals(temppatient.getAddress(),newPatient.getAddress());
        assertEquals(temppatient.getContactNumber(),newPatient.getContactNumber());



    }

    @Test
    void testAddEmptyString() throws IOException {
        Ui ui = null;
        Storage storage = new Storage();
        Map<String,String> tempMap = new HashMap<>();
        tempMap.put("name", "");
        tempMap.put("age", "");
        tempMap.put("address", "");
        tempMap.put("phone", "");
        AddCommand addCommand = new AddCommand(tempMap);
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
        addCommand.execute(ui,storage);
        Patient temppatient = patientList.getPatientList().get(patientList.getPatientList().size() - 1);
        Patient newPatient = new Patient("", -1,"","");
        assertEquals(temppatient.getName(),newPatient.getName());
        assertEquals(temppatient.getAge(),newPatient.getAge());
        assertEquals(temppatient.getAddress(),newPatient.getAddress());
        assertEquals(temppatient.getContactNumber(),newPatient.getContactNumber());



    }

}