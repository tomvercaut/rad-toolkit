package io.github.tomvercaut.dosimetry_tools.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.dosimetry_tools.peeteew.databind.DetectorTypeDeserializer
import io.github.tomvercaut.dosimetry_tools.peeteew.databind.DetectorTypeSerializer

@JacksonXmlRootElement(localName = "MeasuringDevice")
@JsonPropertyOrder(
    "detector", "detectorCalibrationFileName", "electrometer", "electrometerSN", "detectorSN", "scanDevice"
)
class MeasuringDevice {
    @JsonProperty("Detector")
    @JsonSerialize(using = DetectorTypeSerializer::class)
    @JsonDeserialize(using = DetectorTypeDeserializer::class)
    var detector = DetectorType.None

    @JsonProperty("DetectorCalibrationFileName")
    var detectorCalibrationFileName = ""

    @JsonProperty("Electrometer")
    var electrometer = ""

    @JsonProperty("ElectrometerSN")
    var electrometerSN = ""

    @JsonProperty("DetectorSN")
    var detectorSN = ""

    @JsonProperty("ScanDevice")
    var scanDevice = ""
}
