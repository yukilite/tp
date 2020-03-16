package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Appointment;
import seedu.duke.storage.AppointmentList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteAppointmentCommandTest {

    @Test
    void execute() throws Exception {
        AppointmentList appointmentList = new AppointmentList();
        appointmentList.getAppointmentList().add(new Appointment("14/03/2020", "10am"));
        appointmentList.getAppointmentList().add(new Appointment("15/03/2020", "11am"));
        appointmentList.getAppointmentList().add(new Appointment("16/03/2020", "12am"));
        appointmentList.getAppointmentList().add(new Appointment("17/03/2020", "1pm"));
        appointmentList.getAppointmentList().add(new Appointment("18/03/2020", "2pm"));
        Map<String, String> fieldsToChange = new HashMap<>();
        Ui ui = new Ui();
        Storage storage = new Storage();
        fieldsToChange.put("index", "3");
        Command command = new DeleteAppointmentCommand(fieldsToChange);
        command.execute(ui, storage);
        assertEquals("{[Date]: 14/03/2020 |[Time]: 10am}",
                appointmentList.getAppointmentRecord(0).toString());
        assertEquals("{[Date]: 15/03/2020 |[Time]: 11am}",
                appointmentList.getAppointmentRecord(1).toString());
        assertEquals("{[Date]: 17/03/2020 |[Time]: 1pm}",
                appointmentList.getAppointmentRecord(2).toString());
        assertEquals("{[Date]: 18/03/2020 |[Time]: 2pm}",
                appointmentList.getAppointmentRecord(3).toString());
    }
}