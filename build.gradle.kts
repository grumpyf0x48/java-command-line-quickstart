plugins {
    application
    java
    id("org.graalvm.buildtools.native")
}

version = "0.1-SNAPSHOT"

val picocliVersion: String by project
val junitVersion: String by project

dependencies {
    implementation("info.picocli:picocli:${picocliVersion}")
    annotationProcessor("info.picocli:picocli-codegen:${picocliVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.myapplication.Command")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

distributions {
    main {
        contents {
            from("${project.buildDir}/generated") {
                include("myapplication")
                into("completion")
            }
        }
    }
    create("native") {
        contents {
            from("${project.buildDir}/generated") {
                into("completion")
                include("myapplication")
            }
            from("${project.buildDir}/native/nativeCompile") {
                into("bin")
                include("myapplication")
            }
        }
    }
}

val generateCompletion = task("generateCompletion", JavaExec::class) {
    setMain("picocli.AutoComplete")
    setClasspath(files(configurations.compileClasspath, configurations.annotationProcessor, sourceSets["main"].runtimeClasspath))
    doFirst {
        args("--force", "--name=myapplication", "--completionScript=${project.buildDir}/generated/myapplication", "org.grumpyf0x48.myapplication.Command")
    }
}

tasks.distZip {
    dependsOn(generateCompletion)
}

tasks.distTar {
    dependsOn(generateCompletion)
}

tasks.getByName("installNativeDist") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("nativeDistZip") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("nativeDistTar") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

graalvmNative {
    toolchainDetection.set(false)
    binaries {
        all {
            resources.autodetect()
        }
        named("main") {
            imageName.set("myapplication")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
