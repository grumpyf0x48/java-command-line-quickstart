package org.grumpyf0x48.command_line_quickstart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    private final PrintStream initialStdOutStream = System.out;
    private final ByteArrayOutputStream stdOutStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        stdOutStream.reset();
        System.setOut(new PrintStream(stdOutStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(initialStdOutStream);
    }

    @Test
    public void commandCallReturnsZero() {
        Command command = new Command();
        assertEquals(0, command.call());
    }

    @Test
    public void commandWithHelpArgsDisplaysUsage() {
        new CommandLine(new Command()).execute(new String[]{"--help"});
        String expectedOutput = """
            Usage: Command [-hV]
              -h, --help      Show this help message and exit.
              -V, --version   Print version information and exit.
            """;
        assertEquals(expectedOutput, stdOutStream.toString());
    }
}
