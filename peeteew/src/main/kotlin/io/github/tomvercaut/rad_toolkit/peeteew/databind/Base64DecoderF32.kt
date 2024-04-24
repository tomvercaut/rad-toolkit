package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

/**
 * The Base64DecoderF32 class is a custom deserializer for converting a Base64-encoded String to a List of 32-bit (cast as) Double values.
 * It extends the JsonDeserializer class and overrides the deserialize method to implement the conversion logic.
 */
class Base64DecoderF32 : JsonDeserializer<List<Double>>() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): List<Double> {
        val v = p.valueAsString
        val bytes = Base64.getDecoder().decode(v)
        if (bytes.size % BYTE_SIZE != 0) {
            logger.error(String.format("Byte length [%d] is not divisable %d", bytes.size, BYTE_SIZE))
            throw IllegalArgumentException("Base 64 string cannot be converted to a list of 32bit floats")
        }
        val n = bytes.size / BYTE_SIZE
        val buffer = ByteBuffer.allocate(BYTE_SIZE)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        val ld: MutableList<Double> = ArrayList(n)
        var i = 0
        while (i < bytes.size) {
            buffer.clear()
            for (j in 0 until BYTE_SIZE) {
                buffer.put(bytes[i + j])
            }
            buffer.rewind()
            val d = buffer.getFloat().toDouble()
            ld.add(d)
            i += BYTE_SIZE
        }
        return ld
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Base64DecoderF32::class.java)
        private const val BYTE_SIZE = java.lang.Float.BYTES
    }
}
