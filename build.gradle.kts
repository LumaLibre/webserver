plugins {
    java
    kotlin("jvm") version "2.0.21"
}

group = "net.lumamc.web"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://storehouse.okaeri.eu/repository/maven-public/")
}

dependencies {
    implementation("io.javalin:javalin:6.4.0")
    implementation("com.google.code.gson:gson:2.12.1")
    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:5.0.5")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}