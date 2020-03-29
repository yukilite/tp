package seedu.duke.record;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentTest {

    @Test
    void testGetDate() throws ParseException {
        Appointment appointment = new Appointment("22/7/2020", "1230");
        assertEquals("Wed 22 Jul 2020", appointment.getDate());
    }

    @Test
    void testGetTime() throws ParseException {
        Appointment appointment = new Appointment("22/7/2020", "1230");
        assertEquals("12:30 PM", appointment.getTime());
    }

    @Test
    void testToString() throws ParseException {
        Appointment appointment = new Appointment("22/7/2020", "1230");
        assertEquals("{[Date]: Wed 22 Jul 2020 |[Time]: 12:30 PM}", appointment.toString());
    }
}