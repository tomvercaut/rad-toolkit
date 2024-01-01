package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.github.tomvercaut.dosimetry_tools.peeteew.model.MeasurementUnit
import java.io.IOException

class MeasurementUnitDeserializer : JsonDeserializer<MeasurementUnit>() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): MeasurementUnit {
        val v = p.valueAsString
        if (v == "PTW_MEASUNIT_GY") {
            return MeasurementUnit.GY
        } else if (v.equals("NONE", ignoreCase = true)) {
            return MeasurementUnit.NONE
        }
        throw IllegalArgumentException(String.format("Unable to convert [%s] to a MeasurementUnit", v))
    }
}
