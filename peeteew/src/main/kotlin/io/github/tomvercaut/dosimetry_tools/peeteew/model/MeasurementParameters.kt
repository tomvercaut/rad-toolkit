package io.github.tomvercaut.dosimetry_tools.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "MeasurementParameters")
@JsonPropertyOrder("scanDepth")
class MeasurementParameters {
    @JsonProperty("ScanDepth")
    var scanDepth = 0.0
}