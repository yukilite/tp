package seedu.duke.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {

    @Test
    void isExit() {
        Command c = new ExitCommand();
        assertEquals(true,c.isExit());
    }
}