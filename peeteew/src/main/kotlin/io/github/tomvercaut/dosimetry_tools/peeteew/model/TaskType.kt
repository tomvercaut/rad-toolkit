package io.github.tomvercaut.dosimetry_tools.peeteew.model

/**
 * The TaskType enum represents different types of tasks that can be associated with administrative data.
 * It is used in the Administrative class to specify the task name.
 * The available task types are NONE and MEASUREMENT_2D_ARRAY.
 *
 *
 * The NONE task type indicates that no specific task is associated with the administrative data.
 *
 *
 * The MEASUREMENT_2D_ARRAY task type indicates that the administrative data is associated with a 2D array measurement task.
 *
 *
 * Example usage:
 *
 *
 * Administrative administrative = new Administrative();
 * administrative.setTaskName(TaskType.MEASUREMENT_2D_ARRAY);
 * administrative.setModule("VeriSoft 8.0.1.0");
 * administrative.setMeasurementDate(LocalDateTime.of(2023, 12, 5, 17, 57, 22, 219_000_000));
 *
 *
 * Note: The above code is just an example and may not be complete or functional.
 */
enum class TaskType {
    NONE,
    MEASUREMENT_2D_ARRAY,
}