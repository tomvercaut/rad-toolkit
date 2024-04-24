package io.github.tomvercaut.rad_toolkit.peeteew.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomvercaut.rad_toolkit.peeteew.databind.LocalDateTimeWithMillisecondsDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.LocalDateTimeWithMillisecondsSerializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.TaskTypeDeserializer
import io.github.tomvercaut.rad_toolkit.peeteew.databind.TaskTypeSerializer
import java.time.LocalDateTime

@JacksonXmlRootElement(localName = "Adminsitrative")
@JsonPropertyOrder("taskName", "module", "measurementDate")
class Administrative {
    @JsonProperty("TaskName")
    @JsonSerialize(using = TaskTypeSerializer::class)
    @JsonDeserialize(using = TaskTypeDeserializer::class)
    var taskName = TaskType.NONE

    @JsonProperty("Module")
    var module = ""

    @JsonProperty("MeasDate")
    @JsonSerialize(using = LocalDateTimeWithMillisecondsSerializer::class)
    @JsonDeserialize(using = LocalDateTimeWithMillisecondsDeserializer::class)
    var measurementDate: LocalDateTime = LocalDateTime.MIN
}
