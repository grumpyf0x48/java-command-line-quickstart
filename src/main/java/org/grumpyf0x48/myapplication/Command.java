package org.grumpyf0x48.myapplication;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command
public class Command implements Callable<Integer> {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Command()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
