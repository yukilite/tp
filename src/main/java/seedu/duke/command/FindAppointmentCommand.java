package seedu.duke.command;

import seedu.duke.exceptions.InvalidFormatException;
import seedu.duke.record.Appointment;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class deals with the command relating to finding the list of appointments containing a specific keyword.
 * <p></p>
 * <p>
 * This command utilises the functions in {@link seedu.duke.parser.Parser} and searches {@link Appointment} objects
 * within the saved {@link AppointmentList} that is managed by {@link Storage}.
 * </p>
 * <p></p>
 * <p>
 * To elaborate, it converts the output of {@link seedu.duke.parser.Parser} into a {@link Appointment} object, after
 * which the {@link Appointment} object is then
 * added into the {@link AppointmentList} list. Finally, the {@link Storage} class will be used to save the updated
 * list into offline data to reflect the change.
 * </p>
 * @author Brandon Chong
 * @version v2.0
 * @since 28/3/2020
 */
public class FindAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "finda";
    private static final String EXAMPLE = "finda 20/12/2020";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Find an appointment by keyword.\n"
            + "Example: " + EXAMPLE;
    private String searchValue;

    /**
     * Constructor for the find appointment command class.
     *
     * @param searchValue the <code>String</code> object representing the keyword to search for in
     *                    each Appointment object's fields
     */
    public FindAppointmentCommand(String searchValue) throws InvalidFormatException {
        this.searchValue = searchValue;
    }

    public String getsearchValue() {
        return searchValue;
    }

    /**
     * For this execution, the existing list of Appointment records is searched for a keyword.
     * Records that contain the keyword will be added to a separate List and printed out in a readable format.
     *
     * @param ui      the ui object which can be used to display text
     * @param storage the storage object for auto saving function
     * @throws IOException this exception is thrown by the {@link Storage} class if it fails to save the current
     *                     appointment list into offline data.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        List<Appointment> searchResults = new ArrayList<>();
        /*get the list of all Appointments from Storage to conduct search*/
        for (Appointment appointment : AppointmentList.getAppointmentList()) {
            if (appointment.getDate().contains(this.getsearchValue())
                    || appointment.getTime().contains(getsearchValue())) {
                searchResults.add(appointment);
            }
        }
        ui.printAppointmentSearchResults(searchResults);
    }

}
