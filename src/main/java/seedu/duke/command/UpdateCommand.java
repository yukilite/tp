package seedu.duke.command;

import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Map;

/**
 * Edit the information of the patient existed in the patient's list
 *
 * @author Nguyen Thanh Duc
 * @version 0.1
 * @since 2020-03-08
 */
public class UpdateCommand extends Command{

    public static final String COMMAND_WORD = "updatep";
    public static final String EXAMPLE = "updatep \\index 5  \\address Clementi \\number 83487846  ";
    public static final String PATIENT_INDEX = "index";
    public static final String PATIENT_NAME = "name";
    public static final String AGE = "age";
    public static final String ADDRESS = "address";
    public static final String CONTACT_NUMBER = "contactNumber";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Update the information of patient in the list.\n"
            + "Example: " + EXAMPLE;

    private int patientIndex;
    private String patientName;
    private int age;
    private String address;
    private String contactNumber;

    /**
     * Constructor which pass a hash map with keys as fields to change and values
     * as content in that fields that needs to be changed. If there is no need to
     * change in a field in the patient's record, it will be automatically set as
     * null
     *
     * @param fieldsToChange a hash map which pass all the fields needed to be changed
     *                       as key and content as values
     */
    public UpdateCommand(Map<String, String> fieldsToChange) {
        this.patientIndex = Integer.parseInt(fieldsToChange.get(PATIENT_INDEX));
        this.patientName = fieldsToChange.get(PATIENT_NAME);
        boolean isAgeEqualNull = fieldsToChange.get(AGE) == null;
        if(isAgeEqualNull) {
            this.age = -1;
        }
        else {
            this.age = Integer.parseInt(fieldsToChange.get(AGE));
        }
        this.address = fieldsToChange.get(ADDRESS);
        this.contactNumber = fieldsToChange.get(CONTACT_NUMBER);
    }

    /**
     * Method to update the patient by getting the patient's record based on its index
     * and update it based on the queries by users, and auto-save it to the data file
     *
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @throws IOException when there is error in the index's input
     * @see IOException
     * @see PatientList#getPatientRecord
     * @see Patient#setPatientInfo
     * @see Storage#savePatientList
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        // Get the patient's record based on its index from the list
        Patient patient = PatientList.getPatientRecord(patientIndex - 1);

        // Updating the information
        patient.setPatientInfo(patientName,age,address,contactNumber);

        // Updating it back to its corresponding index in the patient's list
        PatientList.getPatientList().set(patientIndex - 1,patient);

        //Auto-save the changes
        storage.savePatientList();

        //ui.showUpdateSuccess(); To be implemented later

    }
}
