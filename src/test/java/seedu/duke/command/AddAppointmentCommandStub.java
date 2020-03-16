package seedu.duke.command;

import java.util.HashMap;
import java.util.Map;

public class AddAppointmentCommandStub {

    private static final String DATE = "date";
    private static final String TIME = "time";
    private String date;
    private String time;

    public AddAppointmentCommandStub(Map<String, String> appointmentInfo) {
        this.date = appointmentInfo.get(DATE);
        this.time = appointmentInfo.get(TIME);
    }

    /**
     * This method is a stub.
     *
     * @see AddAppointmentCommand
     */
    public static Map<String, String> generateMap(int choice) {
        Map<String, String> tempMap = new HashMap<>();
        if (choice == 1) {
            tempMap.put("date", "asd");
            tempMap.put("time", "asdsds");
        } else if (choice == 2) {
            tempMap.put("date", "");
            tempMap.put("time", "");
        }
        return tempMap;
    }

    /**
     * This method is a stub.
     *
     * @see AddAppointmentCommand
     */
    public void execute(int ui, int storage) {
        AppointmentStub newAppointment = new AppointmentStub(this.date, this.time);

        AppointmentListStub.createList(1);
        AppointmentListStub.getAppointmentList().add(newAppointment);
    }
}
