# java-command-line-quickstart

[![Build](https://github.com/grumpyf0x48/java-command-line-quickstart/actions/workflows/build.yml/badge.svg)](https://github.com/grumpyf0x48/java-command-line-quickstart/actions/workflows/build.yml)
[![Native Build](https://github.com/grumpyf0x48/java-command-line-quickstart/actions/workflows/native_build.yml/badge.svg)](https://github.com/grumpyf0x48/java-command-line-quickstart/actions/workflows/native_build.yml)

**java-command-line-quickstart** is a template repository to bootstrap a new command line application using:

- Java 17
- Gradle 8 with Kotlin DSL for build
- GraalVM for native build
- Picocli for command line parsing
- Picocli Code Generation for Bash completion script generation
- Maven Central for dependencies
- JUnit 5 for tests
- EditorConfig for code formatting
- GitHub workflow to build, test, package the application and upload its distributions
- Renovate for dependencies update

## Rename application

By default, this template creates an application named `command_line_quickstart` in the package `org.grumpyf0x48`.

Once you have created a repository using this template, you can rename it for example to `brand-new-app` in a package named `org.your.pkg` using the following command:

```shell
APPLICATION_NAME=brand-new-app \
    PACKAGE_NAME=org.your.pkg \
    make update-application
```

## Package the application

To package the application, run the following command:

```shell
./gradlew distZip
```

## Package the native application

```shell
./gradlew nativeDistZip
```

## Run the application

```shell
./gradlew run "--args=--help"

> Task :run
Usage: Command [-hV]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```

## Run the native application

```shell
./build/native/nativeCompile/command_line_quickstart --help
Usage: Command [-hV]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```
