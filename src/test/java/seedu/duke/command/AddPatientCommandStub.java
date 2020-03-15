package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stub class for fake addCommand class
 */
class AddPatientCommandStub {

    private static final String PATIENT_NAME = "name";
    private static final String AGE = "age";
    private static final String ADDRESS = "address";
    private static final String CONTACT_NUMBER = "phone";
    private String contactNumber;
    private String address;
    private String patientName;
    private int age;

    public AddPatientCommandStub(Map<String, String> patientInfo) {
        this.patientName = patientInfo.get(PATIENT_NAME);
        if (patientInfo.get(AGE).isBlank()) {
            this.age = -1;
        } else {
            try {
                this.age = Integer.parseInt(patientInfo.get(AGE));
            } catch (NumberFormatException e) {
                this.age = -1;
            }

        }
        this.address = patientInfo.get(ADDRESS);
        this.contactNumber = patientInfo.get(CONTACT_NUMBER);
    }

    public static Map<String, String> generateMap(int choice) {
        Map<String, String> tempMap = new HashMap<>();
        if (choice == 1) {
            tempMap.put("name", "asd");
            tempMap.put("age", "23");
            tempMap.put("address", "asdsds");
            tempMap.put("phone", "asdsadsad");
        } else if (choice == 2) {
            tempMap.put("name", "");
            tempMap.put("age", "");
            tempMap.put("address", "");
            tempMap.put("phone", "");
        }
        return tempMap;

    }


    public void execute(int ui, int storage) {
        PatientStub newPatient = new PatientStub(this.patientName, this.age, this.address, this.contactNumber);

        PatientListStub.createList(1);
        PatientListStub.getPatientList().add(newPatient);

    }
}