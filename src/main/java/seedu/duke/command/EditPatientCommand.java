package seedu.duke.command;

import seedu.duke.exceptions.DukeExceptions;
import seedu.duke.exceptions.NoFieldCommandException;
import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Map;

/**
 * Edit the information of the patient existed in the patient's list.
 *
 * @author Nguyen Thanh Duc
 * @version 0.1
 * @since 2020-03-08
 */
public class EditPatientCommand extends Command {

    public static final String COMMAND_WORD = "editp";
    public static final String EXAMPLE = "editp \\index 5  \\address Clementi \\phone 83487846";
    public static final String PATIENT_INDEX = "index";
    public static final String PATIENT_NAME = "name";
    public static final String AGE = "age";
    public static final String ADDRESS = "address";
    public static final String CONTACT_NUMBER = "phone";

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
     * null.
     *
     * @param fieldsToChange a hash map which pass all the fields needed to be changed
     *                       as key and content as values
     */
    public EditPatientCommand(Map<String, String> fieldsToChange) {
        try {
            DukeExceptions.noFieldCommand(fieldsToChange);
            try {
                this.patientIndex = Integer.parseInt(fieldsToChange.get(PATIENT_INDEX));
                if (patientIndex > PatientList.getTotalPatients() || patientIndex <= 0) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer for index");
                //TODO Justin include this ui.showNumberError();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bound, please check the correct index from the list");
                //TODO Justin include this ui.showIndexError();
            }
            this.patientName = fieldsToChange.get(PATIENT_NAME);
            boolean isAgeEqualNull = fieldsToChange.get(AGE).isBlank();
            if (isAgeEqualNull) {
                this.age = -1;
            } else {
                try {
                    this.age = Integer.parseInt(fieldsToChange.get(AGE));
                } catch (NumberFormatException e) {
                    /** TODO: Justin please add this error message too **/
                    System.out.println("Received string for age. Setting age to be -1");
                    this.age = -1;
                }
            }
            this.address = fieldsToChange.get(ADDRESS);
            this.contactNumber = fieldsToChange.get(CONTACT_NUMBER);
        } catch (NoFieldCommandException e) {
            System.out.println("Please do not let the information be empty");
            //TODO Justin include this ui.showEmptyFieldError();
        }
    }

    /**
     * Method to update the patient by getting the patient's record based on its index
     * and update it based on the queries by users, and auto-save it to the data file.
     *
     * @param ui      the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @throws IOException when there is error in the index's input
     * @see IOException
     * @see PatientList#getPatientRecord
     * @see Patient#setPatientInfo
     * @see Storage#savePatientList
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, IndexOutOfBoundsException {
        // Get the patient's record based on its index from the list
        try {
            Patient patient = PatientList.getPatientRecord(patientIndex - 1);

            // Updating the information
            patient.setPatientInfo(patientName, age, address, contactNumber);

            // Updating it back to its corresponding index in the patient's list
            PatientList.getPatientList().set(patientIndex - 1, patient);

            //Auto-save the changes
            storage.savePatientList();

            //TODO Justin ui.showUpdatePatientSuccess(); To be implemented later
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }
}
