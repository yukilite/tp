package seedu.duke.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 * This class converts the String time and date entered by the user into the String of the desired format.
 * @author Samantha Goh
 */
public class TimeConverter {
    /**
     * This method converts the old date into a new date format.
     * @param oldDate the date entered by the user.
     * @return newDate the date in the desired format.
     * @throws ParseException the error occurs if the date is not found.
     */
    public static String oldDate(String oldDate) throws ParseException {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat1.parse(oldDate);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE dd MMM yyyy");
        String newDate = simpleDateFormat2.format(date);
        return newDate;
    }

    /**
     * This method converts the old time into a new time format.
     * @param oldTime the time entered by the user.
     * @return newTime the time in the desired format.
     * @throws ParseException the error occurs if the time is not found.
     */
    public static String oldTime(String oldTime) throws ParseException {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HHmm");
        Date time = simpleDateFormat1.parse(oldTime);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a");
        String newTime = simpleDateFormat2.format(time);
        return newTime;
    }
}
