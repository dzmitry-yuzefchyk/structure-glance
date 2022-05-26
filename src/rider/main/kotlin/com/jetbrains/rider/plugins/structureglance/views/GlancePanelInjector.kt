package com.jetbrains.rider.plugins.structureglance.views

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.project.Project
import com.jetbrains.rd.ide.model.MemberSignature
import com.jetbrains.rd.ide.model.structureGlanceModel
import com.jetbrains.rd.platform.util.idea.ProtocolSubscribedProjectComponent
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rider.projectView.solution
import java.awt.BorderLayout
import javax.swing.JPanel

class GlancePanelInjector(project: Project) : ProtocolSubscribedProjectComponent(project) {
    private var lifetimeDefinition = projectComponentLifetime.createNested()

    init {
        project.solution.structureGlanceModel.openedFile.advise(Lifetime.Eternal) {
            if (it.isNotEmpty())
                injectPanel(it);
        }
    }

    fun injectPanel(signatures: Array<MemberSignature>) {
        val editor = FileEditorManager.getInstance(project).selectedTextEditor ?: return;

        val editorPanel = editor.component as JPanel;
        editorPanel.add(
            GlancePanel(project, editor, signatures),
            BorderLayout.LINE_END
        )
    }
}