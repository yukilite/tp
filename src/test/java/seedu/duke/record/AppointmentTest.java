package seedu.duke.record;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppointmentTest {

    @Test
    void testGetDate() throws ParseException {
        Appointment appointment = new Appointment("22/7/2020", "1230", 1);
        assertEquals("Wed 22 Jul 2020", appointment.getDate());
    }

    @Test
    void testGetTime() throws ParseException {
        Appointment appointment = new Appointment("22/7/2020", "1230", 1);
        assertEquals("12:30 PM", appointment.getTime());
    }

    @Test
    void testToString() throws ParseException {
        Appointment appointment = new Appointment("22/7/2020", "1230", 1);
        assertEquals("{[Date]: Wed 22 Jul 2020 |[Time]: 12:30 PM | [PatientId]: 1}", appointment.toString());
    }

    @Test
    void setAppointmentInfo() {
    }

    @Test
    void testSetDate_TestInputs() throws ParseException {
        String testInput1 = "11/04/2020";
        String testInput2 = "31/12/2020";
        String testInput3 = "01/01/2020";
        String testInputTime = "1200";
        final int pid = 1;
        Appointment appointment1 = new Appointment(testInput1, testInputTime, pid);
        Appointment appointment2 = new Appointment(testInput2, testInputTime, pid);
        Appointment appointment3 = new Appointment(testInput3, testInputTime, pid);
        appointment1.setDate("12/04/2020");
        appointment2.setDate("01/01/2021");
        appointment3.setDate("02/01/2020");
        assertEquals("Sun 12 Apr 2020", appointment1.getDate());
        assertEquals("Fri 01 Jan 2021", appointment2.getDate());
        assertEquals("Thu 02 Jan 2020", appointment3.getDate());
    }

    @Test
    void testSetTime_TestInputs() throws ParseException {
        String testInput1 = "0000";
        String testInput2 = "1200";
        String testInput3 = "2359";
        String testInputDate = "01/01/2020";
        final int pid = 1;
        Appointment appointment1 = new Appointment(testInputDate, testInput1, pid);
        Appointment appointment2 = new Appointment(testInputDate, testInput2, pid);
        Appointment appointment3 = new Appointment(testInputDate, testInput3, pid);
        appointment1.setTime("0001");
        appointment2.setTime("1201");
        appointment3.setTime("0000");
        assertEquals("12:01 AM", appointment1.getTime());
        assertEquals("12:01 PM", appointment2.getTime());
        assertEquals("12:00 AM", appointment3.getTime());
    }

    @Test
    void setPatientId() throws ParseException {
        int testInput1 = 1;
        int testInput2 = 100;
        int testInput3 = 1000;
        String testInputDate = "01/01/2020";
        String testInputTime = "1200";
        Appointment appointment1 = new Appointment(testInputDate, testInputTime, testInput1);
        Appointment appointment2 = new Appointment(testInputDate, testInputTime, testInput2);
        Appointment appointment3 = new Appointment(testInputDate, testInputTime, testInput3);
        appointment1.setPatientId(2);
        appointment2.setPatientId(101);
        appointment3.setPatientId(1001);
        assertEquals(2, appointment1.getPatientId());
        assertEquals(101, appointment2.getPatientId());
        assertEquals(1001, appointment3.getPatientId());
    }

    @Test
    void testSetAppointmentInfo() throws ParseException {
        String testInputDate1 = "01/01/2020";
        String testInputTime1 = "1200";
        String testInputDate2 = "12/04/2020";
        String testInputTime2 = "1600";
        int testInputPid = 100;
        Appointment appointment1 = new Appointment("11/04/2020", "1300", testInputPid);
        Appointment appointment2 = new Appointment("11/04/2020", "1300", testInputPid);
        appointment1.setAppointmentInfo(testInputDate1, testInputTime1);
        appointment2.setAppointmentInfo(testInputDate2, testInputTime2);
        assertEquals("Wed 01 Jan 2020", appointment1.getDate());
        assertEquals("12:00 PM", appointment1.getTime());
        assertEquals("Sun 12 Apr 2020", appointment2.getDate());
        assertEquals("04:00 PM", appointment2.getTime());
    }
}