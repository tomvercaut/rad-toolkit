package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

class Base64EncoderF64 : JsonSerializer<List<Double>>() {
    @Throws(IOException::class)
    override fun serialize(value: List<Double>, gen: JsonGenerator, serializers: SerializerProvider) {
        val buffer = ByteBuffer.allocate(value.size * BYTE_SIZE)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        for (d in value) {
            buffer.putDouble(d)
        }
        buffer.flip()
        val bytes = buffer.array()
        gen.writeString(Base64.getEncoder().encodeToString(bytes))
    }

    companion object {
        private const val BYTE_SIZE = java.lang.Double.BYTES
    }
}
