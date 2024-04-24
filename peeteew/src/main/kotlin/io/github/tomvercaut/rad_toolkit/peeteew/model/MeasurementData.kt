package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "MeasData")
class MeasurementData {
    @JsonProperty("Measurement")
    @JacksonXmlElementWrapper(useWrapping = false)
    val measurements: List<Measurement> = mutableListOf()
}
