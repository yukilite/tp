package seedu.duke.command;

import seedu.duke.record.Appointment;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.converter.TimeConverter;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
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
    private TimeConverter timeConverter;

    /**
     * Constructor for the find appointment command class.
     *
     * @param searchValue the <code>String</code> object representing the keyword to search for in
     *                    each Appointment object's fields
     */
    public FindAppointmentCommand(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchValue() {
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
        boolean isDateInput = false;
        boolean isTimeInput = false;
        if (Integer.valueOf(this.getSearchValue().length()) == 8) {
            if (!checkValidTime(this.getSearchValue())) {
                System.out.println("invalid time form");
                return;
            }
            isTimeInput = true;
        } else if (Integer.valueOf(this.getSearchValue().length()) == 10) {
            if (!checkValidDate(this.getSearchValue())) {
                System.out.println("invalid date form");
                return;
            }
            isDateInput = true;
        } else {
            return;
        }

        String parsedSearchValue = null;

        if (isDateInput){
            try {
                parsedSearchValue = timeConverter.oldDate(timeConverter.convertDate(this.getSearchValue()));
            } catch (ParseException e) {
                System.out.println("conversion problem 1");
            }
        }
        if (isTimeInput) {
            try {
                parsedSearchValue = timeConverter.oldTime(timeConverter.convertTime(this.getSearchValue()));
            } catch (ParseException e) {
                System.out.println("conversion problem 2");
            }

        }

        List<Appointment> searchResults = new ArrayList<>();
        /*get the list of all Appointments from Storage to conduct search*/
        for (Appointment appointment : AppointmentList.getAppointmentList()) {
            if (appointment.getDate().contains(parsedSearchValue)
                    || appointment.getTime().contains(parsedSearchValue)) {
                searchResults.add(appointment);
            }
        }
        ui.printAppointmentSearchResults(searchResults);

    }

    private boolean checkValidDate(String dateInput){
        try {
            this.timeConverter.convertDate(dateInput);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private boolean checkValidTime(String timeInput){
        try {
            this.timeConverter.convertTime(timeInput);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}

