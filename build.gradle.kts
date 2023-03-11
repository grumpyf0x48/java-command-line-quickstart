plugins {
    application
    java
}

version = "0.1-SNAPSHOT"

val picocliVersion = "4.7.1"
val junitVersion = "5.9.2"

dependencies {
    implementation("info.picocli:picocli:${picocliVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.applicationName.Command")
}

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}
