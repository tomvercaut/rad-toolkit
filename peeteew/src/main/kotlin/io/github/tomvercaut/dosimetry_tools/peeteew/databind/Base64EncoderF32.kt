package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

/**
 * Base64EncoderF32 is a subclass of JsonSerializer that is used to serialize a List of Double values to a
 * Base64-encoded String. The Double values are first converted to 32-bit float values and then encoded.
 */
class Base64EncoderF32 : JsonSerializer<List<Double>>() {
    @Throws(IOException::class)
    override fun serialize(value: List<Double>, gen: JsonGenerator, serializers: SerializerProvider) {
        val buffer = ByteBuffer.allocate(value.size * BYTE_SIZE)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        for (d in value) {
            buffer.putFloat(d.toFloat())
        }
        buffer.flip()
        val bytes = buffer.array()
        gen.writeString(Base64.getEncoder().encodeToString(bytes))
    }

    companion object {
        private const val BYTE_SIZE = java.lang.Float.BYTES
    }
}
