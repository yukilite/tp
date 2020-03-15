package seedu.duke.command;


import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Map;

/**
 * This class deals with the command relating to adding of patient into the patient list
 * <p></p>
 * <p>
 * It achieves this by acting as a bridge to connect the functions of {@link seedu.duke.parser.Parser} class,
 * {@link Patient} class and {@link PatientList} class</p>
 * <p></p>
 * <p>To elaborate, it converts the output of {@link seedu.duke.parser.Parser} into a {@link Patient} object, after
 * which the {@link Patient} object is then added into the {@link PatientList} list.
 * </p>
 */
public class AddPatientCommand extends Command {

    public static final String COMMAND_WORD = "addp";
    private static final String PATIENT_NAME = "name";
    private static final String AGE = "age";
    private static final String ADDRESS = "address";
    private static final String CONTACT_NUMBER = "phone";
    private static final String EXAMPLE = "addp \\name Justin \\address Pasir Ris \\age 20 \\phone 98889888";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Add a patient to the patient's list.\n"
            + "Example: " + EXAMPLE;

    private String patientName;
    private int age;
    private String address;
    private String contactNumber;

    /**
     * Constructor for the AddPatientCommand
     * @param patientInfo the map containing the patient information
     */
    public AddPatientCommand(Map<String, String> patientInfo) {
        this.patientName = patientInfo.get(PATIENT_NAME);
        if (patientInfo.get(AGE).isBlank()) {
            this.age = -1;
        } else {
            try {
                this.age = Integer.parseInt(patientInfo.get(AGE));
            } catch (NumberFormatException e) {
                /** If string is given, a message will be shown and the age will be set to -1 **/
                /** TODO: Justin please add this error message too **/
                System.out.println(e + ": Received string for age. Setting age to be -1");
                this.age = -1;
            }

        }
        this.address = patientInfo.get(ADDRESS);
        this.contactNumber = patientInfo.get(CONTACT_NUMBER);
    }

    public int getAge() {
        return this.age;
    }


    /**
     * For this execution, the patient will be added into the patient list.
     * @param ui      ui object for displaying information
     * @param storage storage object to do auto saving
     * @see PatientList#getPatientList
     * @see Storage#savePatientList
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {

        Patient newPatient = new Patient(this.patientName, this.age, this.address, this.contactNumber);

        /** Hacky method to add patient into patient list **/
        PatientList.getPatientList().add(newPatient);

        /** Autosaving upon each add **/
        storage.savePatientList();

        /** Assuming that there is a confimation message indicating the adding of patient is a susccess **/
        //TODO: justin ui.showPatientAddSuccess();
    }
}
