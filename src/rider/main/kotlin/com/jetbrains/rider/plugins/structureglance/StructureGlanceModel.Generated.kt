@file:Suppress("EXPERIMENTAL_API_USAGE","EXPERIMENTAL_UNSIGNED_LITERALS","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName","UnnecessaryVariable","SpellCheckingInspection")
package com.jetbrains.rd.ide.model

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.reflect.KClass



/**
 * #### Generated from [StructureGlanceModel.kt:8]
 */
class StructureGlanceModel private constructor(
    private val _openFile: RdCall<RdDocumentId, Array<MemberSignature>>,
    private val _openedFile: RdSignal<Array<MemberSignature>>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(MemberSignature)
            serializers.register(SignatureType.marshaller)
        }
        
        
        
        private val __MemberSignatureArraySerializer = MemberSignature.array()
        
        const val serializationHash = 1992074248282018964L
        
    }
    override val serializersOwner: ISerializersOwner get() = StructureGlanceModel
    override val serializationHash: Long get() = StructureGlanceModel.serializationHash
    
    //fields
    val openFile: IRdCall<RdDocumentId, Array<MemberSignature>> get() = _openFile
    val openedFile: ISignal<Array<MemberSignature>> get() = _openedFile
    //methods
    //initializer
    init {
        bindableChildren.add("openFile" to _openFile)
        bindableChildren.add("openedFile" to _openedFile)
    }
    
    //secondary constructor
    internal constructor(
    ) : this(
        RdCall<RdDocumentId, Array<MemberSignature>>(AbstractPolymorphic(RdDocumentId), __MemberSignatureArraySerializer),
        RdSignal<Array<MemberSignature>>(__MemberSignatureArraySerializer)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("StructureGlanceModel (")
        printer.indent {
            print("openFile = "); _openFile.print(printer); println()
            print("openedFile = "); _openedFile.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): StructureGlanceModel   {
        return StructureGlanceModel(
            _openFile.deepClonePolymorphic(),
            _openedFile.deepClonePolymorphic()
        )
    }
    //contexts
}
val Solution.structureGlanceModel get() = getOrCreateExtension("structureGlanceModel", ::StructureGlanceModel)



/**
 * #### Generated from [StructureGlanceModel.kt:10]
 */
data class MemberSignature (
    val name: String,
    val type: SignatureType
) : IPrintable {
    //companion
    
    companion object : IMarshaller<MemberSignature> {
        override val _type: KClass<MemberSignature> = MemberSignature::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): MemberSignature  {
            val name = buffer.readString()
            val type = buffer.readEnum<SignatureType>()
            return MemberSignature(name, type)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: MemberSignature)  {
            buffer.writeString(value.name)
            buffer.writeEnum(value.type)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as MemberSignature
        
        if (name != other.name) return false
        if (type != other.type) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + name.hashCode()
        __r = __r*31 + type.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("MemberSignature (")
        printer.indent {
            print("name = "); name.print(printer); println()
            print("type = "); type.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
}


/**
 * #### Generated from [StructureGlanceModel.kt:15]
 */
enum class SignatureType {
    Class, 
    Method, 
    Field, 
    Property, 
    Constructor;
    
    companion object {
        val marshaller = FrameworkMarshallers.enum<SignatureType>()
        
    }
}
