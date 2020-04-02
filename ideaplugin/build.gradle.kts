import org.jetbrains.intellij.tasks.PatchPluginXmlTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.intellij") version "0.4.17"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = uri("https://repo.gradle.org/gradle/libs-releases"))
}

dependencies {
    implementation("org.gradle:gradle-tooling-api:6.3")
    runtimeOnly("org.slf4j:slf4j-simple:1.7.10")
}

tasks.withType<PatchPluginXmlTask> {
    sinceBuild("172")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
