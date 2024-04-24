package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.rad_toolkit.peeteew.databind.GantryRotationDirectionDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.GantryRotationDirectionSerializer

@JacksonXmlRootElement(localName = "AcceleratorSettings")
@JsonPropertyOrder("gantryUprightPosition", "gantryRotationDirection")
class AcceleratorSettings {
    @JsonProperty("GantryUprightPosition")
    val gantryUprightPosition = ""

    @JsonProperty("GantryRotationDirection")
    @JsonSerialize(using = GantryRotationDirectionSerializer::class)
    @JsonDeserialize(using = GantryRotationDirectionDeserializer::class)
    val gantryRotationDirection = GantryRotationDirection.NONE
}
