package io.github.tomvercaut.rad_toolkit.peeteew.io

import io.github.tomvercaut.rad_toolkit.peeteew.model.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.URISyntaxException
import java.time.LocalDateTime

internal class XccTest {
    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    @Throws(URISyntaxException::class)
    fun read() {
        val path = helper.octavius1500Path
        val o = readXcc(path)
        Assertions.assertNotNull(o)
        Assertions.assertTrue(o.isPresent)
        val xcc = o.get()
        Assertions.assertNotNull(xcc)

        Assertions.assertEquals("1.1.0.0", xcc.version)
        Assertions.assertEquals(LocalDateTime.of(2023, 12, 5, 17, 59, 39), xcc.lastModified)

        val content = xcc.content
        Assertions.assertNotNull(content)

        val administrative = content.administrative
        Assertions.assertNotNull(administrative)
        Assertions.assertEquals(TaskType.MEASUREMENT_2D_ARRAY, administrative.taskName)
        Assertions.assertEquals("VeriSoft 8.0.1.0", administrative.module)
        Assertions.assertEquals(LocalDateTime.of(2023, 12, 5, 17, 57, 22, 219000000), administrative.measurementDate)

        val rotationUnit = content.rotationUnit
        Assertions.assertNotNull(rotationUnit)
        Assertions.assertEquals("ptwRURotationDirection_SameAsLinac", rotationUnit.ruRotationDirection)
        Assertions.assertEquals("ptwInclinometerMounting_Normal", rotationUnit.inclometerMounting)

        val acceleratorSettings = content.acceleratorSettings
        Assertions.assertNotNull(acceleratorSettings)
        Assertions.assertEquals("PTW_GANTRYUPRIGHT_0", acceleratorSettings.gantryUprightPosition)
        Assertions.assertEquals(GantryRotationDirection.CW, acceleratorSettings.gantryRotationDirection)

        val inclinometer = content.inclinometer
        Assertions.assertNotNull(inclinometer)
        Assertions.assertEquals("", inclinometer.inclinometerSN)
        Assertions.assertEquals(
            LocalDateTime.of(2023, 12, 5, 17, 57, 22, 219000000),
            inclinometer.measurementDateFirstAngle
        )
        val angleValues = inclinometer.angleValues
        Assertions.assertNotNull(angleValues)
        Assertions.assertEquals(1642, angleValues.size)
        for (d in angleValues) {
            Assertions.assertTrue(d in 0.0..360.0)
        }
        val angleTimes = inclinometer.angleTimes
        Assertions.assertNotNull(angleTimes)
        Assertions.assertEquals(angleValues.size, angleTimes.size)
        for (i in 1 until angleTimes.size) {
            Assertions.assertTrue(angleTimes[i - 1] <= angleTimes[i])
        }

        val measuringDevice = content.measuringDevice
        Assertions.assertNotNull(measuringDevice)
        Assertions.assertEquals(DetectorType.Octavius1500, measuringDevice.detector)
        Assertions.assertEquals("220012001_OCTAVIUS1500_112372.cal", measuringDevice.detectorCalibrationFileName)
        Assertions.assertEquals("PTW_ELECTROMETER_DETECTOR_INTERFACE", measuringDevice.electrometer)
        Assertions.assertEquals("5716", measuringDevice.electrometerSN)
        Assertions.assertEquals("112372", measuringDevice.detectorSN)
        Assertions.assertEquals("PTW_DEVICE_ROTATIONUNIT", measuringDevice.scanDevice)

        val measurementParameters = content.measurementParameters
        Assertions.assertNotNull(measurementParameters)
        Assertions.assertEquals(0.0, measurementParameters.scanDepth)

        val correction = content.correction
        Assertions.assertNotNull(correction)
        Assertions.assertEquals(1013.25, correction.corrAirDensityPressure)
        Assertions.assertEquals(20.0, correction.corrAirDensityTemperature)
        Assertions.assertEquals(1013.25, correction.corrAirDensityReferencePressure)
        Assertions.assertEquals(20.0, correction.corrAirDensityReferenceTemperature)
        Assertions.assertEquals(1.0, correction.corrEnergy)
        Assertions.assertEquals(1.006, correction.corrKUser)
        Assertions.assertEquals("PTW_CORR_AIRDENSITY PTW_CORR_FACTOR ", correction.corrFlags)
        Assertions.assertEquals("0;0;0;0;0", correction.systemSyncAdd)

        val detectorArray = content.detectorArray
        Assertions.assertNotNull(detectorArray)
        Assertions.assertEquals("DoseAccumulated", detectorArray.deviceStoreMode)
        if (measuringDevice.detector == DetectorType.Octavius1500) {
            Assertions.assertEquals(1405, detectorArray.detectorNumbers.size)
            for (i in detectorArray.detectorNumbers.indices) {
                Assertions.assertEquals(i + 1, detectorArray.detectorNumbers[i])
            }
        } else {
            Assertions.fail<Any>("Checks are only implemented for the Octavius 1500.")
        }
        Assertions.assertEquals(-130.0, detectorArray.matrixLeftCoordinate)
        Assertions.assertEquals(130.0, detectorArray.matrixGunCoordinate)
        Assertions.assertEquals(5.0, detectorArray.matrixResolutionLR)
        Assertions.assertEquals(5.0, detectorArray.matrixResolutionGT)
        Assertions.assertEquals(27, detectorArray.matrixNumberOfMeasLR)
        Assertions.assertEquals(27, detectorArray.matrixNumberOfMeasGT)
        Assertions.assertEquals(5.0, detectorArray.chamberDimensionLR)
        Assertions.assertEquals(5.0, detectorArray.chamberDimensionGT)

        val measurementPreset = content.measurementPreset
        Assertions.assertNotNull(measurementPreset)
        Assertions.assertEquals(MeasurementUnit.GY, measurementPreset.measurementUnit)
        Assertions.assertEquals(MeasuringPreset.TIME, measurementPreset.measuringPreset)
        Assertions.assertEquals(222.2, measurementPreset.measurementTime)
        Assertions.assertEquals(0.2, measurementPreset.intervalTime)

        val measurementData = content.measurementData
        Assertions.assertNotNull(measurementData)
        val measurements = measurementData.measurements
        Assertions.assertNotNull(measurements)
        Assertions.assertEquals(1111, measurements.size)

        val measurement = measurements.first()
        Assertions.assertEquals(0.2, measurement.time)
        Assertions.assertEquals(329.8, measurement.angle)
        if (measuringDevice.detector == DetectorType.Octavius1500) {
            Assertions.assertEquals(detectorArray.detectorNumbers.size, measurement.data.size)
        } else {
            Assertions.fail<Any>("Checks are only implemented for the Octavius 1500.")
        }
    }

    companion object {
        private val helper = Helper()
    }
}