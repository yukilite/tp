package seedu.duke.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    @Test
    void getName() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals("peony", patient.getName());
    }

    @Test
    void testGetAge() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals(33, patient.getAge());
    }

    @Test
    void testGetAddress() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals("clementi road", patient.getAddress());
    }

    @Test
    void testGetContactNumber() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals("61234567", patient.getContactNumber());
    }

    @Test
    void testToString() {
        Patient patient = new Patient("john", 45, "jail", "91234567");
        assertEquals("{[Name]: john | [Age]: 45 | [Address]: jail | [Contact Number]: 91234567}",
                patient.toString());
    }

    @Test
    void testSetName() {
        Patient patient = new Patient("peony", 33, "clementi road", "91234567");
        patient.setName("peony");
        assertEquals("peony", patient.getName());
    }


    @Test
    void testSetAge() {
        Patient patient = new Patient("peony", 33, "clementi road", "91234567");
        patient.setAge(33);
        assertEquals(33, patient.getAge());
    }


    @Test
    void testSetAddress() {
        Patient patient = new Patient("peony", 33, "clementi road", "91234567");
        patient.setAddress("clementi road");
        assertEquals("clementi road", patient.getAddress());
    }


    @Test
    void testSetContactNumber() {
        Patient patient = new Patient("peony", 33, "clementi road", "91234567");
        patient.setContactNumber("11111111");
        assertEquals("11111111", patient.getContactNumber());
    }


    @Test
    void testSetPatientInfo() {
        Patient patient = new Patient("peony", 33, "clementi road", "91234567");
        patient.setPatientInfo("chucky", 11, "im going to kill you", "44444444");
        assertEquals("chucky", patient.getName());
        assertEquals(11, patient.getAge());
        assertEquals("im going to kill you", patient.getAddress());
        assertEquals("44444444", patient.getContactNumber());
    }
}