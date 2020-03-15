package seedu.duke.command;

import seedu.duke.command.Command;
import seedu.duke.record.Appointment;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Map;

/**
 * Delete an appointment's record with certain index in the appointment's list
 *
 * @author Nguyen Thanh Duc
 * @version 1.0
 * @since 2020-03-14
 */
public class DeleteAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "deletea";
    public static final String EXAMPLE = "deletea \\index 12";
    private static final String APPOINTMENT_INDEX = "index";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Delete an appointment from the list.\n"
            + "Example: " + EXAMPLE;

    private int index;

    /**
     * Constructor which pass a hash map with only 1 item containing the index of
     * the patient that needs to be removed
     *
     * @param fieldsToChange a hash map with only 1 item which is a field called
     *                       "index" and the value of the index needed to delete
     */
    public DeleteAppointmentCommand(Map<String, String> fieldsToChange) {
        this.index = Integer.parseInt(fieldsToChange.get(APPOINTMENT_INDEX));
    }

    /**
     * Method to delete the appointment from the list by getting that appointment's index then
     * remove it and auto-save the changes
     *
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @throws IOException when there is error in the index's input
     * @see IOException
     * @see AppointmentList#getAppointmentRecord
     * @see Storage#saveAppointmentsList
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {

        // Get the appointment's record based on its index from the list
        Appointment appointment = AppointmentList.getAppointmentRecord(index - 1);

        // Remove the appointment's information from the patient's list
        AppointmentList.getAppointmentList().remove(appointment);

        //Auto-save the changes
        storage.saveAppointmentsList();

        //TODO Justin ui.showDeleteAppointmentSuccess(); To be implemented later
    }
}
