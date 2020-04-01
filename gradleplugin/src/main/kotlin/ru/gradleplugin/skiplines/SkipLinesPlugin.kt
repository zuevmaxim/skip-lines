package ru.gradleplugin.skiplines

import org.gradle.api.Plugin
import org.gradle.api.Project

class SkipLinesPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.create("skip", SkipTask::class.java)
    }
}
