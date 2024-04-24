package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.model.DetectorType
import java.io.IOException

class DetectorTypeDeserializer : JsonDeserializer<DetectorType>() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DetectorType {
        val v = p.valueAsString
        if (v == "PTW_DETECTOR_OCTAVIUS_1500") {
            return DetectorType.Octavius1500
        } else if (v.equals("NONE", ignoreCase = true)) {
            return DetectorType.None
        }
        throw IllegalArgumentException(String.format("Unable to convert [%s] to a DetectorType", v))
    }
}
