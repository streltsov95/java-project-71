plugins {
    id("java")
    application
    checkstyle
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.51.0"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")
    testImplementation(platform("org.junit:junit-bom:5.11.0-M2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.0-M2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "hexlet.code.App"
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports { xml.required.set(true) } }