package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.rad_toolkit.peeteew.databind.LocalDateTimeNoMillisecondsDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.LocalDateTimeNoMillisecondsSerializer
import java.time.LocalDateTime

@JacksonXmlRootElement(localName = "PTW")
@JsonPropertyOrder("version", "lastModified", "content")
class Xcc {
    @JsonProperty("Version")
    var version = ""

    @JsonProperty("LastModified")
    @JsonSerialize(using = LocalDateTimeNoMillisecondsSerializer::class)
    @JsonDeserialize(using = LocalDateTimeNoMillisecondsDeserializer::class)
    var lastModified: LocalDateTime = LocalDateTime.MIN

    @JsonProperty("Content")
    var content = Content()
}
