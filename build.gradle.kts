import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.rak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

plugins {
    kotlin("jvm") version "1.3.71"
    idea
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    testCompile("junit:junit:4.12")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit:1.2.51")
    testCompile("org.jetbrains.kotlin:kotlin-test:1.3.50")
}