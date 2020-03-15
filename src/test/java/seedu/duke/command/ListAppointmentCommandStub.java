package seedu.duke.command;

import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.List;

public class ListAppointmentCommandStub {
    public ListAppointmentCommandStub() {
    }

    public void execute(int ui, int storage) {

        List<AppointmentStub> appointmentStubList = AppointmentListStub.getAppointmentList();
        for (AppointmentStub a : appointmentStubList) {
            System.out.println(a);
        }

    }
}
