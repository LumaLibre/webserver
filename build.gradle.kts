import java.nio.file.Path

plugins {
    java
    kotlin("jvm") version "2.0.21"
    id("com.gradleup.shadow") version "8.3.5"
    //id("dev.jsinco.pterodactyldeploy") version "1.2-SNAPSHOT"
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
    implementation("org.slf4j:slf4j-simple:2.0.16")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks {

    shadowJar {
        dependencies {

        }

        manifest {
            attributes["Main-Class"] = "net.lumamc.web.MainKt"
        }
        archiveClassifier.set("")
        // omit version
        archiveVersion.set("")
    }

    jar {
        enabled = false
    }

    build {
        dependsOn(shadowJar)
        //finalizedBy(pterodactylDeploy)
    }
}
