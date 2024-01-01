package io.github.tomvercaut.dosimetry_tools.peeteew.databind

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
 * The Base64DecoderU16 class is a custom deserializer that converts a Base64-encoded string to a list of 16-bit unsigned integers.
 */
class Base64DecoderU16 : JsonDeserializer<List<Int>>() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): List<Int> {
        val v = p.valueAsString
        val bytes = Base64.getDecoder().decode(v)
        if (bytes.size % BYTE_SIZE != 0) {
            logger.error(String.format("byte length [%d] is not divisable %d", bytes.size, BYTE_SIZE))
            throw IllegalArgumentException("base 64 string cannot be converted to a list of 16bit unsigned integers")
        }
        val n = bytes.size / BYTE_SIZE
        val buffer = ByteBuffer.allocate(BYTE_SIZE)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        val ld: MutableList<Int> = ArrayList(n)
        var i = 0
        while (i < bytes.size) {
            buffer.clear()
            for (j in 0 until BYTE_SIZE) {
                buffer.put(bytes[i + j])
            }
            buffer.rewind()
            val d = buffer.getShort()
            ld.add(java.lang.Short.toUnsignedInt(d))
            i += 2
        }
        return ld
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Base64DecoderU16::class.java)
        private const val BYTE_SIZE = java.lang.Short.BYTES
    }
}
