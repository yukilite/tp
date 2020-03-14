package seedu.duke.command;

import seedu.duke.exceptions.DukeExceptions;
import seedu.duke.exceptions.NoFieldCommandException;
import seedu.duke.record.Appointment;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Map;

/**
 * Edit the information of the appointment existed in the appointment's list
 *
 * @author Nguyen Thanh Duc
 * @version 1.0
 * @since 2020-03-14
 */
public class UpdateAppointmentCommand extends Command{
    public static final String COMMAND_WORD = "edita";
    public static final String EXAMPLE = "edita \\index 5  \\date 01/03/2020 \\time 10am";
    public static final String APPOINTMENT_INDEX = "index";
    public static final String APPOINTMENT_DATE = "date";
    public static final String APPOINTMENT_TIME = "time";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Update the information of appointment in the list.\n"
            + "Example: " + EXAMPLE;

    private int index;
    private String date;
    private String time;

    /**
     * Constructor which pass a hash map with keys as fields to change and values
     * as content in that fields that needs to be changed. If there is no need to
     * change in a field in the appointment's record, it will be automatically set as
     * null
     *
     * @param fieldsToChange a hash map which pass all the fields needed to be changed
     *                       as key and content as values
     */
    public UpdateAppointmentCommand(Map<String, String> fieldsToChange) {
        try {
            DukeExceptions.noFieldCommand(fieldsToChange);
            try {
                this.index = Integer.parseInt(fieldsToChange.get(APPOINTMENT_INDEX));
                if(index > PatientList.getTotalPatients() && index <= 0) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer for index");
                //TODO Justin include this ui.showNumberError();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bound, please check the correct index from the list");
                //TODO Justin include this ui.showIndexError();
            }
            this.date = fieldsToChange.get(APPOINTMENT_DATE);
            this.time = fieldsToChange.get(APPOINTMENT_TIME);
        } catch (NoFieldCommandException e) {
            System.out.println("Please do not let the information be empty");
            //TODO Justin include this ui.showEmptyFieldError();
        }
    }

    /**
     * Method to update the appointment by getting the appointment's record based on its index
     * and update it based on the queries by users, and auto-save it to the data file
     *
     * @param ui the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @throws IOException when there is error in the index's input
     * @see IOException
     * @see AppointmentList#getAppointmentRecord
     * @see Appointment#setAppointmentInfo
     * @see Storage#saveAppointmentsList
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        try {
            // Get the appointment's record based on its index from the list
            Appointment appointment = AppointmentList.getAppointmentRecord(index - 1);

            // Updating the information
            appointment.setAppointmentInfo(date, time);

            // Updating it back to its corresponding index in the appointment's list
            AppointmentList.getAppointmentList().set(index - 1, appointment);

            //Auto-save the changes
            storage.saveAppointmentsList();

            //TODO Justin ui.showUpdateAppointmentSuccess(); To be implemented later
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }
}
