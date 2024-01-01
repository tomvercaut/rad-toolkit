package io.github.tomvercaut.dosimetry_tools.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.dosimetry_tools.peeteew.databind.Base64DecoderF32
import io.github.tomvercaut.dosimetry_tools.peeteew.databind.Base64EncoderF32

@JacksonXmlRootElement(localName = "Measurement")
@JsonPropertyOrder(
    "time", "angle", "data"
)
class Measurement {
    @JsonProperty("Time")
    var time = 0.0

    @JsonProperty("Angle")
    var angle = 0.0

    @JsonProperty("Data")
    @JsonSerialize(using = Base64EncoderF32::class)
    @JsonDeserialize(using = Base64DecoderF32::class)
    var data: List<Double> = ArrayList()
}
