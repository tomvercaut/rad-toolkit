package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.github.tomvercaut.dosimetry_tools.peeteew.model.DetectorType
import java.io.IOException

class DetectorTypeSerializer : JsonSerializer<DetectorType>() {
    @Throws(IOException::class)
    override fun serialize(value: DetectorType, gen: JsonGenerator, serializers: SerializerProvider) {
        if (value == DetectorType.Octavius1500) {
            gen.writeString("PTW_DETECTOR_OCTAVIUS_1500")
        } else if (value == DetectorType.None) {
            gen.writeString("NONE")
        }
        throw IllegalArgumentException(
            String.format(
                "Not all match cases were covered [%s], unable to convert DetectorType to XML",
                value
            )
        )
    }
}
