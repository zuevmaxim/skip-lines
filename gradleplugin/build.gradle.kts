import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-gradle-plugin")
}

dependencies {
    // tests
    val junitVersion = "5.1.0"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

gradlePlugin {
    plugins {
        create("SkipLinesPlugin") {
            id = "ru.gradleplugin.skiplines.skip"
            implementationClass = "ru.gradleplugin.skiplines.SkipLinesPlugin"
        }
    }
}
