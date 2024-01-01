package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.github.tomvercaut.dosimetry_tools.peeteew.model.MeasuringPreset
import java.io.IOException

class MeasuringPresetSerializer : JsonSerializer<MeasuringPreset?>() {
    @Throws(IOException::class)
    override fun serialize(value: MeasuringPreset?, gen: JsonGenerator, serializers: SerializerProvider) {
        if (value == null) return
        when (value) {
            MeasuringPreset.NONE -> gen.writeString("NONE")
            MeasuringPreset.TIME -> gen.writeString("PTW_MEASPRESET_TIME")
        }
        throw IllegalArgumentException(
            String.format(
                "Not all match cases were covered [%s], unable to convert MeasPreset to XML",
                value
            )
        )
    }
}
