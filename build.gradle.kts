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
    mainClass.set("org.grumpyf0x48.applicationName.Command")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

graalvmNative {
    toolchainDetection.set(false)
    binaries {
        all {
            resources.autodetect()
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
