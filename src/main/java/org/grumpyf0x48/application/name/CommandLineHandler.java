package org.grumpyf0x48.application.name;

import lombok.RequiredArgsConstructor;
import org.grumpyf0x48.application.name.commands.MyCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
@RequiredArgsConstructor
public class CommandLineHandler implements CommandLineRunner, ExitCodeGenerator {

    private final MyCommand myCommand;

    private final IFactory commandLineFactory;

    private int exitCode;

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(myCommand, commandLineFactory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
