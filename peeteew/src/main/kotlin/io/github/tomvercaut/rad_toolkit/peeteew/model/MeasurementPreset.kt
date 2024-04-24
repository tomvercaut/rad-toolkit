package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.rad_toolkit.peeteew.databind.MeasurementUnitDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.MeasurementUnitSerializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.MeasuringPresetDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.MeasuringPresetSerializer

@JacksonXmlRootElement(localName = "MeasurementPreset")
@JsonPropertyOrder(
    "measurementUnit", "measuringPreset", "measurementTime", "intervalTime"
)
class MeasurementPreset {
    @JsonProperty("MeasUnit")
    @JsonSerialize(using = MeasurementUnitSerializer::class)
    @JsonDeserialize(using = MeasurementUnitDeserializer::class)
    var measurementUnit = MeasurementUnit.NONE

    @JsonProperty("MeasPreset")
    @JsonSerialize(using = MeasuringPresetSerializer::class)
    @JsonDeserialize(using = MeasuringPresetDeserializer::class)
    var measuringPreset = MeasuringPreset.NONE

    @JsonProperty("MeasTime")
    var measurementTime = 0.0

    @JsonProperty("IntervalTime")
    var intervalTime = 0.0
}
