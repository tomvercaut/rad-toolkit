package io.github.tomvercaut.dosimetry_tools.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.dosimetry_tools.peeteew.databind.Base64DecoderU16
import io.github.tomvercaut.dosimetry_tools.peeteew.databind.Base64EncoderU16

@JacksonXmlRootElement(localName = "DetectorArray")
@JsonPropertyOrder(
    "deviceStoreMode",
    "detectorNumbers",
    "matrixLeftCoordinate",
    "matrixGunCoordinate",
    "matrixResolutionLR",
    "matrixResolutionGT",
    "matrixNumberOfMeasLR",
    "matrixNumberOfMeasGT",
    "chamberDimensionLR",
    "chamberDimensionGT"
)
class DetectorArray {
    @JsonProperty("DeviceStoreMode")
    var deviceStoreMode = ""

    @JsonProperty("DetectorNumbers")
    @JsonSerialize(using = Base64EncoderU16::class)
    @JsonDeserialize(using = Base64DecoderU16::class)
    var detectorNumbers: List<Int> = mutableListOf()

    @JsonProperty("MatrixLeftCoordinate")
    var matrixLeftCoordinate = 0.0

    @JsonProperty("MatrixGunCoordinate")
    var matrixGunCoordinate = 0.0

    @JsonProperty("MatrixResolutionLR")
    var matrixResolutionLR = 0.0

    @JsonProperty("MatrixResolutionGT")
    var matrixResolutionGT = 0.0

    @JsonProperty("MatrixNumberOfMeasLR")
    var matrixNumberOfMeasLR = 0

    @JsonProperty("MatrixNumberOfMeasGT")
    var matrixNumberOfMeasGT = 0

    @JsonProperty("ChamberDimensionLR")
    var chamberDimensionLR = 0.0

    @JsonProperty("ChamberDimensionGT")
    var chamberDimensionGT = 0.0
}
