package io.github.tomvercaut.rad_toolkit.peeteew.algo

import io.github.tomvercaut.rad_toolkit.peeteew.algo.XccAccumulator.accumulate
import io.github.tomvercaut.rad_toolkit.peeteew.io.readXcc
import io.github.tomvercaut.rad_toolkit.peeteew.model.Helper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URISyntaxException

internal class XccAccumulatorTest {
    @Test
    @Throws(URISyntaxException::class, IllegalArgumentException::class)
    fun accumulate() {
        val path = helper.octavius1500Path
        val o = readXcc(path)
        assertNotNull(o)
        assertTrue(o.isPresent)
        val xcc = o.get()
        assertNotNull(xcc)

        val list = accumulate(xcc)
        assertNotNull(list)
        assertFalse(list.isEmpty())

        var max = Double.MIN_VALUE
        for (d in list) {
            if (d >= max) max = d
        }
        LOGGER.debug("Max value in accumulated data: $max")
    }

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(XccAccumulatorTest::class.java)

        private val helper = Helper()
    }
}