# java-command-line-quickstart

[![Build](https://github.com/grumpyf0x48/java-command-line-quickstart/actions/workflows/gradle.yml/badge.svg)](https://github.com/grumpyf0x48/java-command-line-quickstart/actions/workflows/gradle.yml)

**java-command-line-quickstart** is a template repository to bootstrap a new command line application using:

- Java 17
- Gradle 7 for build
- Picocli for command line parsing
- Maven Central for dependencies
- JUnit 5 for tests
- EditorConfig for code formatting
- Renovate for dependencies update
- GitHub workflow for running tests

Usage:

```shell
./gradlew run "--args=--help"

> Task :run
Usage: Command [-hV]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```
