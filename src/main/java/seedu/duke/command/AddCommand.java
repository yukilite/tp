package seedu.duke.command;

import seedu.duke.record.Patient;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.Map;

public class AddCommand extends Command{

    private static final String PATIENT_NAME = "name";
    private static final String AGE = "age";
    private static final String ADDRESS = "address";
    private static final String CONTACT_NUMBER = "phone";

    private String patientName;
    private String age;
    private String address;
    private String contactNumber;

    /**
     * Constructor for the AddCommand
     * @param patientInfo the map containing the patient information
     */
    public AddCommand(Map<String,String> patientInfo) {
        this.patientName = patientInfo.get(PATIENT_NAME);
        this.age = patientInfo.get(AGE);
        this.address = patientInfo.get(ADDRESS);
        this.contactNumber = patientInfo.get(CONTACT_NUMBER);
    }


    /**
     * For this execution, the patient will be added into the patient list.
     * @param ui ui object for displaying information
     * @param storage storage object to do auto saving
     * @see PatientList#getPatientList
     * @see Storage#savePatientList
     */
    @Override
    public void execute(Ui ui, Storage storage) {

        Patient newPatient = new Patient(this.patientName, this.age, this.address, this.contactNumber);

        /** Hacky method to add patient into patient list **/
        PatientList.getPatientList().add(newPatient);

        /** Autosaving upon each add **/
        storage.savePatientList(PatientList.getPatientList());

        /** Assuming that there is a confimation message indicating the adding of patient is a susccess **/
        ui.showSuccessAdd();

    }
}
