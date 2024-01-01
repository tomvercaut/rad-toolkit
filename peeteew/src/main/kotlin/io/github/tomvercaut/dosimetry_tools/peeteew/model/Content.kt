package io.github.tomvercaut.dosimetry_tools.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "Content")
@JsonPropertyOrder(
    "administrative",
    "rotationUnit",
    "acceleratorSettings",
    "inclinometer",
    "measuringDevice",
    "measurementParameters",
    "correction",
    "detectorArray",
    "measurementPreset",
    "measurementData"
)
class Content {
    @JsonProperty("Adminsitrative")
    var administrative = Administrative()

    @JsonProperty("RotationUnit")
    var rotationUnit = RotationUnit()

    @JsonProperty("AcceleratorSettings")
    var acceleratorSettings = AcceleratorSettings()

    @JsonProperty("Inclinometer")
    var inclinometer = Inclinometer()

    @JsonProperty("MeasuringDevice")
    var measuringDevice = MeasuringDevice()

    @JsonProperty("MeasurementParameters")
    var measurementParameters = MeasurementParameters()

    @JsonProperty("Correction")
    var correction = Correction()

    @JsonProperty("DetectorArray")
    var detectorArray = DetectorArray()

    @JsonProperty("MeasurementPreset")
    var measurementPreset = MeasurementPreset()

    @JsonProperty("MeasData")
    var measurementData = MeasurementData()
}
