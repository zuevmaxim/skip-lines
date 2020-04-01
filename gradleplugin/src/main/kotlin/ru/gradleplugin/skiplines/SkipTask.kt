package ru.gradleplugin.skiplines

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option
import java.io.File
import java.io.PrintStream

open class SkipTask : DefaultTask() {
    @Input
    var fileName: String? = null

    @Option(option = "fileName", description = "File to process")
    fun setUpFileName(file: String) {
        fileName = file
    }

    @TaskAction
    fun skipLinesInFile() {
        val fileName = fileName ?: error("File name is null")
        val file = File(fileName)
        skipAndWrite(file, System.out)
    }

    companion object {
        private val skipRegex = Regex("^#skip [0-9]+.*")
        private val numberRegex = Regex("[0-9]+")

        fun skipAndWrite(file: File, out: PrintStream) {
            check(file.canRead()) { "Can not read from file ${file.path}" }
            val lines = file.readLines()
            skip(lines).forEach { out.println(it) }
        }

        fun skip(lines: List<String>): List<String> {
            var skipCount = 0
            return lines.filter { line ->
                when {
                    skipCount > 0 -> {
                        skipCount--
                        false
                    }
                    line.matches(skipRegex) -> {
                        skipCount = numberRegex.find(line)!!.value.toInt()
                        false
                    }
                    else -> true
                }
            }
        }
    }
}
