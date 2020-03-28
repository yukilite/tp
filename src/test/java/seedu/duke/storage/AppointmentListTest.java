package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Appointment;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentListTest {
    private AppointmentList testAppointmentList = new AppointmentList();
    private Appointment testAppointment1 = new Appointment("29/03/2020", "1300");
    private Appointment testAppointment2 = new Appointment("28/03/2020", "1400");
    private Appointment testAppointment3 = new Appointment("27/03/2020", "1500");

    AppointmentListTest() throws ParseException {
    }

    @Test
    void appointmentListTest_Add() {
        testAppointmentList.getAppointmentList().add(testAppointment1);
        testAppointmentList.getAppointmentList().add(testAppointment2);
        testAppointmentList.getAppointmentList().add(testAppointment3);
        assertEquals(3, testAppointmentList.getTotalAppointments());
    }

    @Test
    void appointmentListTest_GetInfo() {
        testAppointmentList.getAppointmentList().add(testAppointment1);
        assertEquals("Sun 29 Mar 2020", testAppointmentList.getAppointmentRecord(0).getDate());
        assertEquals("01:00 pm", testAppointmentList.getAppointmentRecord(0).getTime());
    }

    @Test
    void appointmentListTest_Delete() {
        testAppointmentList.getAppointmentList().add(testAppointment1);
        testAppointmentList.getAppointmentList().add(testAppointment2);
        testAppointmentList.getAppointmentList().add(testAppointment3);
        testAppointmentList.removeAppointmentRecord(0);
        assertEquals(2, testAppointmentList.getTotalAppointments());
        assertEquals("Sat 28 Mar 2020", testAppointmentList.getAppointmentRecord(0).getDate());

    }
}