plugins {
    application
    java
    id("org.graalvm.buildtools.native")
}

val version: String by project
val javaVersion: String by project

val picocliVersion: String by project
val junitVersion: String by project

dependencies {
    implementation("info.picocli:picocli:${picocliVersion}")
    annotationProcessor("info.picocli:picocli-codegen:${picocliVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.command_line_quickstart.Command")
}

java {
    sourceCompatibility = JavaVersion.toVersion("${javaVersion}")
    targetCompatibility = JavaVersion.toVersion("${javaVersion}")
}

distributions {
    main {
        contents {
            from("${project.buildDir}/generated") {
                include("command_line_quickstart")
                into("completion")
            }
        }
    }
    create("native") {
        contents {
            from("${project.buildDir}/generated") {
                include("command_line_quickstart")
                into("completion")
            }
            from("${project.buildDir}/native/nativeCompile") {
                include("command_line_quickstart")
                into("bin")
            }
        }
    }
}

val generateCompletion = task("generateCompletion", JavaExec::class) {
    setMain("picocli.AutoComplete")
    setClasspath(files(configurations.compileClasspath, configurations.annotationProcessor, sourceSets["main"].runtimeClasspath))
    doFirst {
        args("--force", "--name=command_line_quickstart", "--completionScript=${project.buildDir}/generated/command_line_quickstart", "org.grumpyf0x48.command_line_quickstart.Command")
    }
}

tasks.distZip {
    dependsOn(generateCompletion)
}

tasks.distTar {
    dependsOn(generateCompletion)
}

tasks.getByName("nativeDistZip") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("nativeDistTar") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("installNativeDist") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

graalvmNative {
    toolchainDetection.set(false)
    binaries {
        all {
            buildArgs.add("--initialize-at-build-time=org.junit.platform.launcher.core.LauncherConfig")
            buildArgs.add("--initialize-at-build-time=org.junit.jupiter.engine.config.InstantiatingConfigurationParameterConverter")
            resources.autodetect()
        }
        named("main") {
            imageName.set("command_line_quickstart")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
