package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.rad_toolkit.peeteew.databind.*
import java.time.LocalDateTime

@JacksonXmlRootElement(localName = "Inclinometer")
@JsonPropertyOrder(
    "inclinometerSN", "measurementDateFirstAngle", "angleValues", "angleTimes"
)
class Inclinometer {
    @JsonProperty("InclinometerSN")
    var inclinometerSN = ""

    @JsonProperty("MeasDateFirstAngle")
    @JsonSerialize(using = LocalDateTimeWithMillisecondsSerializer::class)
    @JsonDeserialize(using = LocalDateTimeWithMillisecondsDeserializer::class)
    var measurementDateFirstAngle: LocalDateTime = LocalDateTime.MIN

    @JsonProperty("AngleValues")
    @JsonSerialize(using = Base64EncoderF32::class)
    @JsonDeserialize(using = Base64DecoderF32::class)
    var angleValues: List<Double> = mutableListOf()

    @JsonProperty("AngleTimes")
    @JsonSerialize(using = Base64EncoderF64::class)
    @JsonDeserialize(using = Base64DecoderF64::class)
    var angleTimes: List<Double> = mutableListOf()
}
