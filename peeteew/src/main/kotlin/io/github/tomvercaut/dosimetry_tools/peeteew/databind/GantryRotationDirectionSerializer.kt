package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.github.tomvercaut.dosimetry_tools.peeteew.model.GantryRotationDirection
import java.io.IOException

/**
 * GantryRotationDirectionSerializer is a custom serializer for the GantryRotationDirection enum.
 * It serializes the enum values into their corresponding string representations.
 */
class GantryRotationDirectionSerializer : JsonSerializer<GantryRotationDirection?>() {
    @Throws(IOException::class)
    override fun serialize(value: GantryRotationDirection?, gen: JsonGenerator, serializers: SerializerProvider) {
        if (value == null) return
        when (value) {
            GantryRotationDirection.NONE -> gen.writeString("NONE")
            GantryRotationDirection.CW -> gen.writeString("PTW_GANTRYROTATION_CW")
            GantryRotationDirection.CC -> gen.writeString("PTW_GANTRYROTATION_CC")
        }
        throw IllegalArgumentException(
            String.format(
                "Not all match cases were covered [%s], unable to convert GantryRotationDirection to XML",
                value
            )
        )
    }
}
