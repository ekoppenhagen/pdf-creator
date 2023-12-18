group = "com.github.ekoppenhagen"
version = "0.0.0-alpha"

kotlin {
    jvmToolchain(jdkVersion = 21)
}

plugins {
    val kotlinVersion = "1.9.21"
    val detektVersion = "1.23.4"

    kotlin("jvm") version kotlinVersion
    id("io.gitlab.arturbosch.detekt") version detektVersion
}

dependencies {
    val detektVersion = "1.23.4"
    val junitJupiterVersion = "5.10.1"
    val kotestVersion = "5.8.0"

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-rules-libraries:$detektVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
}

detekt {
    toolVersion = "1.23.4"
    config.setFrom(file("detekt.yml"))
    buildUponDefaultConfig = true
}

tasks.test(Test::useJUnitPlatform)

repositories(RepositoryHandler::mavenCentral)
