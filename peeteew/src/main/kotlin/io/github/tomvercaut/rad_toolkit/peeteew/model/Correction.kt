package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "Correction")
@JsonPropertyOrder(
    "corrAirDensityPressure",
    "corrAirDensityTemperature",
    "corrAirDensityReferencePressure",
    "corrAirDensityReferenceTemperature",
    "corrEnergy",
    "corrKUser",
    "corrFlags",
    "systemSyncAdd"
)
class Correction {
    @JsonProperty("CorrAirDensityPressure")
    var corrAirDensityPressure: Double = 0.0

    @JsonProperty("CorrAirDensityTemperature")
    var corrAirDensityTemperature: Double = 0.0

    @JsonProperty("CorrAirDensityReferencePressure")
    var corrAirDensityReferencePressure: Double = 0.0

    @JsonProperty("CorrAirDensityReferenceTemperature")
    var corrAirDensityReferenceTemperature: Double = 0.0

    @JsonProperty("CorrEnergy")
    var corrEnergy: Double = 0.0

    @JsonProperty("CorrKUser")
    var corrKUser: Double = 0.0

    @JsonProperty("CorrFlags")
    var corrFlags: String = ""

    @JsonProperty("SystemSyncAdd")
    var systemSyncAdd: String = ""
}
