package seedu.duke.command;

import java.util.List;

/**
 * Stub class for ListAppointmentCommandTest.
 */
public class ListAppointmentCommandStub {
    public ListAppointmentCommandStub() {
    }

    /**
     * Stub to simulate adding appointments into list.
     *
     * @param ui      stub ui
     * @param storage stub storage
     */
    public void execute(int ui, int storage) {
        List<AppointmentStub> appointmentStubList = AppointmentListStub.getAppointmentList();
        for (AppointmentStub a : appointmentStubList) {
            System.out.println(a);
        }
    }
}
