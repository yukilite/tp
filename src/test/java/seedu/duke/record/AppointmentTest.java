package seedu.duke.record;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
    void testSetDate_successfullyChangedDate() {
        try {
            Appointment appointment = new Appointment("22/05/2020", "1230", 1);
            String testDateBlank = "";

            appointment.setDate(testDateBlank);
            assertEquals("Fri 22 May 2020", appointment.getDate());

            String testDateNotBlank = "23/05/2020";

            appointment.setDate(testDateNotBlank);
            assertEquals("Sat 23 May 2020", appointment.getDate());
        } catch (ParseException e) {
            fail("Should not have caught any errors, all given dates are of correct form");
        }
    }

    @Test
    void testSetDate_unsuccessfullyChangedDate() {
        final String testCase1 = "Friday the thirteen";
        final String testCase2 = "Fri 22 May 2020";
        final String testCase3 = "2020/05/22";
        final String testCase4 = "05/22/2020";
        final String testCase5 = "31/02/2020";

        final ArrayList<String> wrongTestCases = new ArrayList<>();

        wrongTestCases.add(testCase1);
        wrongTestCases.add(testCase2);
        wrongTestCases.add(testCase3);
        wrongTestCases.add(testCase4);
        wrongTestCases.add(testCase5);

        Appointment appointment = null;

        try {
            appointment = new Appointment("22/05/2020", "1230", 1);
        } catch (Exception e) {
            fail("Should not have failed when creating new appointment");
        }

        for (String wrongUserInput : wrongTestCases) {
            try {
                appointment.setDate(wrongUserInput);
                fail("Should not have reach this line of code as all formatted provided are wrong and will trigger "
                        + "Exception");

            } catch (ParseException e) {
                assertTrue(true);

            } catch (Exception e) {
                fail("No other exception should have been caught");
            }
        }
    }

    @Test
    void testSetTime_successfullyChangedTime() {
        final String testCase1 = "1234";
        final String testCase2 = "1100";
        final String testCase3 = "1200";
        final String testCase4 = "0000";
        final String testCase5 = "";

        Appointment appointment = null;

        try {
            appointment = new Appointment("22/05/2020", "1230", 1);
        } catch (Exception e) {
            fail("Should not have failed when creating new appointment");
        }

        try {
            appointment.setTime(testCase1);
            assertEquals("12:34 PM", appointment.getTime());

        } catch (Exception e) {
            fail("Should not have caught any exceptions as all format provided are correct");
        }

        try {
            appointment.setTime(testCase2);
            assertEquals("11:00 AM", appointment.getTime());

        } catch (Exception e) {
            fail("Should not have caught any exceptions as all format provided are correct");
        }

        try {
            appointment.setTime(testCase3);
            assertEquals("12:00 PM", appointment.getTime());

        } catch (Exception e) {
            fail("Should not have caught any exceptions as all format provided are correct");
        }

        try {
            appointment.setTime(testCase4);
            assertEquals("12:00 AM", appointment.getTime());

        } catch (Exception e) {
            fail("Should not have caught any exceptions as all format provided are correct");
        }

        try {
            appointment.setTime(testCase5);
            assertEquals("12:00 AM", appointment.getTime());

        } catch (Exception e) {
            fail("Should not have caught any exceptions as all format provided are correct");
        }
    }

    @Test
    void testSetTime_unsuccessfullyChangedTime() {
        final String testCase1 = "9999";
        final String testCase2 = "2000/";
        final String testCase3 = "/2000";
        final String testCase4 = "-1234";
        final String testCase5 = "Friday";

        final ArrayList<String> wrongTestCases = new ArrayList<>();

        wrongTestCases.add(testCase1);
        //wrongTestCases.add(testCase2); //Sam ~
        wrongTestCases.add(testCase3);
        wrongTestCases.add(testCase4);
        wrongTestCases.add(testCase5);

        Appointment appointment = null;

        try {
            appointment = new Appointment("22/05/2020", "1230", 1);
        } catch (Exception e) {
            fail("Should not have failed when creating new appointment");
        }

        for (String wrongUserInput : wrongTestCases) {
            try {
                appointment.setTime(wrongUserInput);
                fail("Should not have reach this line of code as all formatted provided are wrong and will trigger "
                        + "Exception");

            } catch (ParseException e) {
                assertTrue(true);

            } catch (Exception e) {
                fail("No other exception should have been caught");
            }
        }
    }

    @Test
    void testSetAppointmentInfo() {
        final String correctDate = "22/05/2020";
        final String correctTime = "1234";

        Appointment appointment = null;

        try {
            appointment = new Appointment("31/07/2020", "1000", 1);

        } catch (Exception e) {
            fail("No exception should have been thrown");
        }

        try {
            appointment.setAppointmentInfo(correctDate, correctTime);
            assertEquals("12:34 PM", appointment.getTime());
            assertEquals("Fri 22 May 2020", appointment.getDate());

        } catch (ParseException e) {
            fail("Should not have failed");
        }
    }

    @Test
    void testSetPatientId() {

        Appointment appointment = null;

        try {
            appointment = new Appointment("31/07/2020", "1000", 1);

        } catch (Exception e) {
            fail("No exception should have been thrown");
        }

        try {
            appointment.setPatientId(2);
            assertEquals(2, appointment.getPatientId());
        } catch (Exception e) {
            fail("No exceptions should have been thrown");
        }

    }
}