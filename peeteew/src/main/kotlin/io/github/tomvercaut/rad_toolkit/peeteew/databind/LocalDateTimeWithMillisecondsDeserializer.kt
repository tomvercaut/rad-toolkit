package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JacksonException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * LocalDateTimeWithMillisecondsDeserializer is a subclass of JsonDeserializer that is used to deserialize
 * a JSON string representation of LocalDateTime objects with millisecond precision to LocalDateTime objects.
 */
class LocalDateTimeWithMillisecondsDeserializer : JsonDeserializer<LocalDateTime>() {
    @Throws(IOException::class, JacksonException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime {
        return LocalDateTime.parse(p.valueAsString, formatter)
    }

    companion object {
        private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    }
}
