package seedu.duke.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TimeConverter {
    public static String oldDate(String oldDate) throws ParseException {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat1.parse(oldDate);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE dd MMM yyyy");
        String newDate = simpleDateFormat2.format(date);
        return newDate;
    }
    public static String oldTime(String oldTime) throws ParseException {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HHmm");
        Date time = simpleDateFormat1.parse(oldTime);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a");
        String newTime = simpleDateFormat2.format(time);
        return newTime;
    }
}
