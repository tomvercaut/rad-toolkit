package io.github.tomvercaut.dosimetry_tools.peeteew

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object Utils {

    private val formatWithoutMilli: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    private val formatWithMill: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")

    /**
     * Parse a date time string used in Xcc and Mcc format.
     * Format example:
     *
     *  * 2023-12-05 17:59:39
     *  * 2023-12-05 17:59:39.219
     *
     *
     * @param s string to be parsed
     * @return Local date time
     * @throws DateTimeParseException if the function fails to parse the string
     */
    @JvmStatic
    @Throws(DateTimeParseException::class)
    fun localDateTime(s: String, hasMilliseconds: Boolean): LocalDateTime {
        val ldt = if (hasMilliseconds) {
            LocalDateTime.parse(s, formatWithMill)
        } else {
            LocalDateTime.parse(s, formatWithoutMilli)
        }
        return ldt
    }
}
