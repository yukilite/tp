package seedu.duke.command;

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
