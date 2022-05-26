package com.jetbrains.rider.plugins.structureglance.views

import com.intellij.icons.AllIcons
import com.intellij.icons.AllIcons.Icons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.event.VisibleAreaEvent
import com.intellij.openapi.editor.event.VisibleAreaListener
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager
import com.intellij.ui.components.labels.LinkLabel
import com.jetbrains.rd.ide.model.MemberSignature
import com.jetbrains.rd.platform.util.idea.ProtocolSubscribedProjectComponent
import icons.ReSharperIcons
import icons.RiderIcons
import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JPanel

class GlancePanel(
    private val project: Project,
    private val editor: Editor,
    private val members: Array<MemberSignature>
) : JPanel() {
    init {
        preferredSize = Dimension(200, 0)
        isOpaque = false
        layout = BoxLayout(this, BoxLayout.PAGE_AXIS)
        parseDeclarations()
    }

    private fun parseDeclarations() {
        for (signature in members) {
            val button = LinkLabel<String>(signature.name, AllIcons.Nodes.Method);
            this.add(button);
        }
    }
}