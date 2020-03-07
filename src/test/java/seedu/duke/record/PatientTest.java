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
    void getAge() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals(33, patient.getAge());
    }

    @Test
    void getAddress() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals("clementi road", patient.getAddress());
    }

    @Test
    void getContactNumber() {
        Patient patient = new Patient("peony", 33, "clementi road", "61234567" );
        assertEquals("61234567", patient.getContactNumber());
    }

    @Test
    void testToString() {
        Patient patient = new Patient("john", 45, "jail", "91234567");
        assertEquals("{[Name]: john | [Age]: 45 | [Address]: jail | [Contact Number]: 91234567}",
                patient.toString());
    }
}