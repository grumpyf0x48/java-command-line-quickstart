package org.grumpyf0x48.applicationName;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    public void commandCallReturnsO() {
        Command command = new Command();
        assertEquals(0, command.call());
    }
}
