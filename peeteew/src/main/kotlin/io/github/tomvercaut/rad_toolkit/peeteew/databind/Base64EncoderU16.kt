package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

/**
 * This class is responsible for encoding a list of unsigned 16-bit integers into Base64 format.
 * It extends the JsonSerializer class and overrides its serialize method.
 * The encoding process involves allocating a ByteBuffer with little endian byte order,
 * converting each unsigned 16-bit integer in the list to a short and putting it in the buffer,
 * flipping the buffer, converting it to a byte array, and finally encoding it into Base64 format using the java.util.Base64 Encoder.
 */
class Base64EncoderU16 : JsonSerializer<List<Int>>() {
    @Throws(IOException::class)
    override fun serialize(value: List<Int>, gen: JsonGenerator, serializers: SerializerProvider) {
        val buffer = ByteBuffer.allocate(value.size * bs)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        for (d in value) {
            buffer.putShort(d.toShort())
        }
        buffer.flip()
        val bytes = buffer.array()
        gen.writeString(Base64.getEncoder().encodeToString(bytes))
    }

    companion object {
        private const val bs = java.lang.Short.BYTES
    }
}
