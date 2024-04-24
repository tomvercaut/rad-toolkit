package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "RotationUnit")
@JsonPropertyOrder("ruRotationDirection", "inclometerMounting")
class RotationUnit {
    @JsonProperty("RURotationDirection")
    var ruRotationDirection = ""

    @JsonProperty("InclinometerMounting")
    var inclometerMounting = ""
}
