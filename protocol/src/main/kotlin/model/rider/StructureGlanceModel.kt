package model.rider

import com.jetbrains.rd.generator.nova.*
import com.jetbrains.rd.generator.nova.PredefinedType.string
import com.jetbrains.rider.model.nova.ide.SolutionModel

@Suppress("unused")
object StructureGlanceModel : Ext(SolutionModel.Solution) {

    val MemberSignature = structdef {
        field("name", string)
        field("type", SignatureType)
    }

    val SignatureType = enum {
        +"Class"
        +"Method"
        +"Field"
        +"Property"
        +"Constructor"
    }

    init {
        call("openFile", SolutionModel.RdDocumentId, array(MemberSignature))
        signal("openedFile", array(MemberSignature))
//        call("openFile1", PsiFile, array(MemberSignature))
    }
}