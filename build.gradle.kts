import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.qameta.allure") version "2.9.6"
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.dlapenko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    testImplementation("org.seleniumhq.selenium:selenium-devtools:4.0.0-rc-1")
    testImplementation("com.codeborne:selenide:6.2.1")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    // Proxy
    testImplementation("com.browserup:browserup-proxy-core:2.1.2")
    testRuntimeOnly("io.netty:netty-all:4.1.72.Final")
    testRuntimeOnly("io.netty:netty-codec:4.1.72.Final")


    // Allure
    implementation("io.qameta.allure:allure-junit5:2.17.2")
    testImplementation("io.qameta.allure:allure-selenide:2.17.2") {
        isTransitive = true
    }
}

allure {
    version.set("2.17.2")
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        frameworks.junit5.adapterVersion.set("2.17.2")
    }
}

tasks.test {
    useJUnitPlatform()

    testLogging.showStandardStreams = true
    outputs.upToDateWhen { false }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}