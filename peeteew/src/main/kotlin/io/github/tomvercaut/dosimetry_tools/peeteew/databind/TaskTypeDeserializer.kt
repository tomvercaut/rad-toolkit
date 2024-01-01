package io.github.tomvercaut.dosimetry_tools.peeteew.databind

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.github.tomvercaut.dosimetry_tools.peeteew.model.TaskType
import java.io.IOException

class TaskTypeDeserializer : JsonDeserializer<TaskType>() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): TaskType {
        val v = p.valueAsString
        if (v == "2D_ARRAY_MEASUREMENT") {
            return TaskType.MEASUREMENT_2D_ARRAY
        } else if (v.equals("NONE", ignoreCase = true)) {
            return TaskType.NONE
        }
        throw IOException(String.format("Unable to convert [%s] to a TaskType", v))
    }
}
