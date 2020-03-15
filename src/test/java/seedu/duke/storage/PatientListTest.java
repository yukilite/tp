package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;

import static org.junit.jupiter.api.Assertions.*;

class PatientListTest {
    private PatientList testPatientList = new PatientList();
    private Patient testPatient1 = new Patient("alice", 11, "bukit timah", "61111111" );
    private Patient testPatient2 = new Patient("bob", 22, "novena", "822222222" );
    private Patient testPatient3 = new Patient("chong", 33, "pasir ris", "93333333" );

    @Test
    void patientListTest_Add() {
        testPatientList.getPatientList().add(testPatient1);
        testPatientList.getPatientList().add(testPatient2);
        testPatientList.getPatientList().add(testPatient3);
        assertEquals(3, testPatientList.getTotalPatients());
    }

    @Test
    void patientListTest_GetInfo() {
        testPatientList.getPatientList().add(testPatient1);
        assertEquals("alice", testPatientList.getPatientRecord(0).getName());
        assertEquals(11, testPatientList.getPatientRecord(0).getAge());
        assertEquals("bukit timah", testPatientList.getPatientRecord(0).getAddress());
        assertEquals("61111111", testPatientList.getPatientRecord(0).getContactNumber());
    }

    @Test
    void patientListTest_Delete() {
        testPatientList.getPatientList().add(testPatient1);
        testPatientList.getPatientList().add(testPatient2);
        testPatientList.getPatientList().add(testPatient3);
        testPatientList.removePatientRecord(0);
        assertEquals(2, testPatientList.getTotalPatients());
        assertEquals("bob", testPatientList.getPatientRecord(0).getName());
    }

}