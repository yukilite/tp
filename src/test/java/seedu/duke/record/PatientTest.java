package seedu.duke.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testToString() {
        Patient patient = new Patient("john", "jail", "91234567");
        assertEquals("{[Name]: john | [Address]: jail | [Contact Number]: 91234567}",
                patient.toString());
    }
}