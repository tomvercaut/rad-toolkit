package io.github.tomvercaut.rad_toolkit.peeteew.io

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.github.tomvercaut.rad_toolkit.peeteew.model.Xcc
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.file.Path
import java.util.*

private val logger: Logger = LoggerFactory.getLogger("XccReader")
private val mapper: ObjectMapper = XmlMapper().apply {
    registerModule(JavaTimeModule())
}

/**
 * Reads an Xcc object from the given file path.
 *
 * @param path the path to the XML file
 * @return an Optional containing the parsed Xcc object, or an empty Optional if an error occurred
 */
fun readXcc(path: Path): Optional<Xcc> {
    try {
        val xcc = mapper.readValue(path.toFile(), Xcc::class.java)
        return Optional.ofNullable(xcc)
    } catch (e: IOException) {
        logger.error(String.format("An error occurred while reading: ", path), e)
        return Optional.empty()
    }
}
