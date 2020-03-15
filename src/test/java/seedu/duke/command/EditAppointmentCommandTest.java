package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Appointment;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static seedu.duke.command.EditAppointmentCommand.APPOINTMENT_DATE;
import static seedu.duke.command.EditAppointmentCommand.APPOINTMENT_INDEX;
import static seedu.duke.command.EditAppointmentCommand.APPOINTMENT_TIME;


class EditAppointmentCommandTest {

    //Test case 1
    @Test
    void execute_1() throws Exception {
        AppointmentList appointmentList = new AppointmentList();
        appointmentList.getAppointmentList().add(new Appointment("14/03/2020", "10am"));
        appointmentList.getAppointmentList().add(new Appointment("15/03/2020", "11am"));
        appointmentList.getAppointmentList().add(new Appointment("16/03/2020", "12am"));
        appointmentList.getAppointmentList().add(new Appointment("17/03/2020", "1pm"));
        appointmentList.getAppointmentList().add(new Appointment("18/03/2020", "2pm"));
        Map<String, String> fieldsToChange = new HashMap<>();
        fieldsToChange.put(APPOINTMENT_INDEX, "3");
        fieldsToChange.put(APPOINTMENT_DATE, "31/12/2020");
        fieldsToChange.put(APPOINTMENT_TIME, "11pm");
        Command command = new EditAppointmentCommand(fieldsToChange);
        Ui ui = new Ui();
        Storage storage = new Storage();
        command.execute(ui, storage);
        assertEquals("{[Date]: 31/12/2020 |[Time]: 11pm}",
                appointmentList.getAppointmentRecord(2).toString());
    }

    //Test case 2
    @Test
    void execute_2() throws Exception {
        AppointmentList appointmentList = new AppointmentList();
        appointmentList.getAppointmentList().add(new Appointment("14/03/2020", "10am"));
        appointmentList.getAppointmentList().add(new Appointment("15/03/2020", "11am"));
        appointmentList.getAppointmentList().add(new Appointment("16/03/2020", "12am"));
        appointmentList.getAppointmentList().add(new Appointment("17/03/2020", "1pm"));
        appointmentList.getAppointmentList().add(new Appointment("18/03/2020", "2pm"));
        Map<String, String> fieldsToChange = new HashMap<>();
        fieldsToChange.put(APPOINTMENT_INDEX, "5");
        fieldsToChange.put(APPOINTMENT_DATE, "");
        fieldsToChange.put(APPOINTMENT_TIME, "11pm");
        Command command = new EditAppointmentCommand(fieldsToChange);
        Ui ui = new Ui();
        Storage storage = new Storage();
        command.execute(ui, storage);
        assertEquals("{[Date]: 18/03/2020 |[Time]: 11pm}",
                appointmentList.getAppointmentRecord(4).toString());
    }
}