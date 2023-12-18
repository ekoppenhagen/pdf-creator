group = "com.github.ekoppenhagen"
version = "0.0.0-alpha"

kotlin {
    jvmToolchain(jdkVersion = 21)
}

plugins {
    kotlin("jvm") version "1.9.21"
}

dependencies {
    val junitJupiterVersion = "5.10.1"
    val kotestVersion = "5.8.0"

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
}

tasks.test(Test::useJUnitPlatform)

repositories(RepositoryHandler::mavenCentral)
