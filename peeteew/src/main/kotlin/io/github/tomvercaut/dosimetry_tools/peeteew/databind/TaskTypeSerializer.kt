package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.github.tomvercaut.dosimetry_tools.peeteew.model.TaskType
import java.io.IOException

class TaskTypeSerializer : JsonSerializer<TaskType?>() {
    @Throws(IOException::class)
    override fun serialize(value: TaskType?, gen: JsonGenerator, serializers: SerializerProvider) {
        if (value == null) return
        when (value) {
            TaskType.NONE -> gen.writeString("NONE")
            TaskType.MEASUREMENT_2D_ARRAY -> gen.writeString("2D_ARRAY_MEASUREMENT")
        }
        throw IllegalArgumentException(
            String.format(
                "Not all match cases were covered [%s], unable to convert TaskType to XML",
                value
            )
        )
    }
}
