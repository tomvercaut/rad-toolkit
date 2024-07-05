plugins {
    id("io.github.tomvercaut.rad-toolkit.kotlin-library-conventions")
}

dependencies {
    implementation(libs.jetbrains.annotations)
    implementation(libs.dom4j)
    implementation(libs.jackson.core)
    implementation(libs.jackson.dataformat)
    implementation(libs.jackson.datatype)
    implementation(libs.logback.classic)
    implementation(libs.logback.core)
    implementation(libs.slf4j.api)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
}