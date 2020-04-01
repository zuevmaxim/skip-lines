package ru.ideaplugin.skiplines

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.Messages
import org.gradle.tooling.GradleConnector
import java.io.ByteArrayOutputStream
import java.io.File


class SkipLinesAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val descriptor = FileChooserDescriptor(true, false, false, false, false, false).apply {
            description = "Choose file to skip lines"
            this.withFileFilter { File(it.path).canRead() }
        }

        FileChooser.chooseFile(descriptor, e.project, null) { file ->
            val project = e.project?.basePath!!
            val out = ByteArrayOutputStream()
            GradleConnector.newConnector()
                .forProjectDirectory(File(project))
                .connect().use { connection ->
                    connection.newBuild()
                        .withArguments("skip", "--fileName", file.path)
                        .setStandardOutput(out)
                        .setStandardError(out)
                        .run()
                }
            Messages.showInfoMessage(e.project, out.toString(), "Skip result")
        }
    }
}
