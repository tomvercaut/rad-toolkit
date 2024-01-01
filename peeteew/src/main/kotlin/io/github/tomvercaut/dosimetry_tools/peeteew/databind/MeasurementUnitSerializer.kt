package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.github.tomvercaut.dosimetry_tools.peeteew.model.MeasurementUnit
import java.io.IOException

/**
 * The MeasurementUnitSerializer class is a JsonSerializer implementation that is used to serialize MeasurementUnit objects to JSON representation (String).
 */
class MeasurementUnitSerializer : JsonSerializer<MeasurementUnit>() {
    @Throws(IOException::class)
    override fun serialize(value: MeasurementUnit, gen: JsonGenerator, serializers: SerializerProvider) {
        if (value == MeasurementUnit.GY) {
            gen.writeString("PTW_MEASUNIT_GY")
        } else if (value == MeasurementUnit.NONE) {
            gen.writeString("NONE")
        }
        throw IllegalArgumentException(
            String.format(
                "Not all match cases were covered [%s], unable to convert MeasurementUnit to XML",
                value
            )
        )
    }
}
