package io.github.tomvercaut.rad_toolkit.peeteew.databind

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.model.MeasuringPreset
import java.io.IOException

class MeasuringPresetDeserializer : JsonDeserializer<MeasuringPreset>() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): MeasuringPreset {
        val v = p.valueAsString
        if (v == "PTW_MEASPRESET_TIME") {
            return MeasuringPreset.TIME
        } else if (v.equals("NONE", ignoreCase = true)) {
            return MeasuringPreset.NONE
        }
        throw IllegalArgumentException(String.format("Unable to convert [%s] to a MeasPreset", v))
    }
}
