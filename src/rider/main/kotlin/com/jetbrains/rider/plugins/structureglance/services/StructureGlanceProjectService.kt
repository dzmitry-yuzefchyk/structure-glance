package com.jetbrains.rider.plugins.structureglance.services

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.jetbrains.rd.ide.model.StructureGlanceModel
import com.jetbrains.rd.ide.model.structureGlanceModel
import com.jetbrains.rider.projectView.solution

class StructureGlanceProjectService(private val project: Project) {
    val structureGlance: StructureGlanceModel = project.solution.structureGlanceModel

    companion object {
        fun getInstance(project: Project): StructureGlanceProjectService = project.service()
    }
}