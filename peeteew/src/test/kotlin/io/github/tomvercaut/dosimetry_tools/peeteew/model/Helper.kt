package io.github.tomvercaut.dosimetry_tools.peeteew.model

import java.net.URISyntaxException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

class Helper {
    @get:Throws(URISyntaxException::class)
    val octavius1500Path: Path
        /**
         * Retrieves the path of the "octavius_1500.xcc" resource file.
         *
         * @return The path of the "octavius_1500.xcc" resource file.
         * @throws URISyntaxException if a URI syntax error occurs.
         */
        get() {
            val loader = javaClass.classLoader
            val uri = Objects.requireNonNull(loader.getResource("octavius_1500.xcc")).toURI()
            return Paths.get(uri)
        }
}