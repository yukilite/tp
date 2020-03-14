package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Appointment;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentListTest {
    private AppointmentList testAppointmentList = new AppointmentList();
    private Appointment testAppointment1 = new Appointment("april 1", "13:00");
    private Appointment testAppointment2 = new Appointment("jun 4", "14:00");
    private Appointment testAppointment3 = new Appointment("oct 11", "15:00");

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
        assertEquals("april 1", testAppointmentList.getAppointmentRecord(1).getDate());
        assertEquals(11, testAppointmentList.getAppointmentRecord(1).getTime());
    }

    @Test
    void appointmentListTest_Delete() {
        testAppointmentList.getAppointmentList().add(testAppointment1);
        testAppointmentList.getAppointmentList().add(testAppointment2);
        testAppointmentList.getAppointmentList().add(testAppointment3);
        testAppointmentList.removeAppointmentRecord(1);
        assertEquals(2, testAppointmentList.getTotalAppointments());
        assertEquals("jun 4", testAppointmentList.getAppointmentRecord(1).getDate());

    }
}