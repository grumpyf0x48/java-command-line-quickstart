package org.grumpyf0x48.application.name.commands;

import lombok.RequiredArgsConstructor;
import org.grumpyf0x48.application.name.services.MyService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Component
@RequiredArgsConstructor
@Command
public class MyCommand implements Callable<Integer> {

    private final MyService myService;

    @Option(names = "-o", description = "optional option")
    private String option;

    @Override
    public Integer call() {
        System.out.printf("%s from %s called with: %s%n", myService.hello(), this.getClass().getName(), option);
        return 0;
    }
}
