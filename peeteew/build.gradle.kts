plugins {
    id("io.github.tomvercaut.dosimetry_tools.kotlin-library-conventions")
}

dependencies {
    implementation("org.jetbrains:annotations")
    implementation("org.dom4j:dom4j")
    implementation("com.fasterxml.jackson.core:jackson-core")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("ch.qos.logback:logback-classic")
    implementation("ch.qos.logback:logback-core")
    implementation("org.slf4j:slf4j-api")
}