package org.grumpyf0x48.myapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    public void commandCallReturnsO() throws Exception {
        Command command = new Command();
        assertEquals(0, command.call());
    }
}
