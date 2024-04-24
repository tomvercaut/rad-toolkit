package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JacksonException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * The LocalDateTimeNoMillisecondsDeserializer class is a custom Deserializer for LocalDateTime objects.
 * It extends the JsonDeserializer class from the Jackson library.
 * This Deserializer is used to parse a JSON String representation of a LocalDateTime object without milliseconds.
 * The format of the JSON String representation should be "yyyy-MM-dd HH:mm:ss".
 *
 *
 * Example usage:
 *
 *
 * ObjectMapper objectMapper = new ObjectMapper();
 * SimpleModule module = new SimpleModule();
 * module.addDeserializer(LocalDateTime.class, new LocalDateTimeNoMillisecondsDeserializer());
 * objectMapper.registerModule(module);
 *
 *
 * LocalDateTime dateTime = objectMapper.readValue("\"2022-07-21 10:30:55\"", LocalDateTime.class);
 */
class LocalDateTimeNoMillisecondsDeserializer : JsonDeserializer<LocalDateTime>() {
    @Throws(IOException::class, JacksonException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime {
        return LocalDateTime.parse(p.valueAsString, formatter)
    }

    companion object {
        private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    }
}
