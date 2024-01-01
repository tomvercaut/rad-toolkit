package io.github.tomvercaut.dosimetry_tools.peeteew.algo

import io.github.tomvercaut.dosimetry_tools.peeteew.model.Measurement
import io.github.tomvercaut.dosimetry_tools.peeteew.model.Xcc

object XccAccumulator {
    /**
     * Accumulates the data from a list of measurements.
     *
     * @param xcc The Xcc object containing the measurements.
     * @return A list of accumulated double values.
     */
    @JvmStatic
    @Throws(IllegalArgumentException::class)
    fun accumulate(xcc: Xcc): List<Double> {
        val measurements: List<Measurement>
        try {
            measurements = xcc.content.measurementData.measurements
        } catch (e: NullPointerException) {
            return ArrayList()
        }
        val n = try {
            measurements.first().data.size
        } catch (e: NullPointerException) {
            0
        } catch (e: NoSuchElementException) {
            0
        }
        if (n == 0) {
            return ArrayList()
        }
        val data: MutableList<Double> = ArrayList(n)
        for (i in 0 until n) {
            data.add(0.0)
        }
        for (measurement in measurements) {
            val tdata = measurement.data
            require(n == tdata.size) { "Measurements have different data sizes" }
            for (i in 0 until n) {
                data[i] = data[i] + tdata[i]
            }
        }
        return data
    }
}
