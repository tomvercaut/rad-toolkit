package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JacksonException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.model.GantryRotationDirection
import java.io.IOException

/**
 * GantryRotationDirectionDeserializer is a custom deserializer for the GantryRotationDirection enum.
 * It deserializes the JSON string representation into the corresponding GantryRotationDirection value.
 */
class GantryRotationDirectionDeserializer : JsonDeserializer<GantryRotationDirection>() {
    @Throws(IOException::class, JacksonException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): GantryRotationDirection {
        val v = p.valueAsString
        if (v == "PTW_GANTRYROTATION_CW") {
            return GantryRotationDirection.CW
        } else if (v.equals("PTW_GANTRYROTATION_CC", ignoreCase = true)) {
            return GantryRotationDirection.CC
        } else if (v.equals("NONE", ignoreCase = true)) {
            return GantryRotationDirection.NONE
        }
        throw IllegalArgumentException(String.format("Unable to convert [%s] to a GantryRotationDirection", v))
    }
}
