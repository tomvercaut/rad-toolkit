package io.github.tomvercaut.dosimetry_tools.peeteew

import io.github.tomvercaut.dosimetry_tools.peeteew.Utils.localDateTime
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.format.DateTimeParseException

internal class UtilsTest {
    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun localDateTimeWithMillSeconds() {
        val s = "2023-12-05 17:57:22.219"
        val t = localDateTime(s, true)
        assertNotNull(t)
        assertEquals(2023, t.year)
        assertEquals(12, t.monthValue)
        assertEquals(5, t.dayOfMonth)
        assertEquals(17, t.hour)
        assertEquals(57, t.minute)
        assertEquals(22, t.second)
        assertEquals(219000000, t.nano)
    }

    @Test
    fun localDateTimeWithoutMillSeconds() {
        val s = "2023-12-05 17:57:22"
        val t = localDateTime(s, false)
        assertNotNull(t)
        assertEquals(2023, t.year)
        assertEquals(12, t.monthValue)
        assertEquals(5, t.dayOfMonth)
        assertEquals(17, t.hour)
        assertEquals(57, t.minute)
        assertEquals(22, t.second)
    }

    @Test
    fun localDateTimeWithMillSeconds_expectException() {
        val s = "2023-12-05 17:57:22"
        assertThrows(DateTimeParseException::class.java) {
            localDateTime(s, true)
        }
    }

    @Test
    fun localDateTimeWithoutMillSeconds_expectException() {
        val s = "2023-12-05 17:57:22.219"
        assertThrows(DateTimeParseException::class.java) {
            localDateTime(s, false)
        }
    }
}