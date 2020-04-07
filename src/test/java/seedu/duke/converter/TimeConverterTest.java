package seedu.duke.converter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TimeConverterTest {

    @Test
    void testOldDate() throws ParseException {
        String oldDate = "29/3/2020";
        assertEquals("Sun 29 Mar 2020", TimeConverter.oldDate(oldDate));
    }

    @Test
    void testOldTime() throws ParseException {
        String oldTime = "2315";
        assertEquals("11:15 PM", TimeConverter.oldTime(oldTime));
    }
}
