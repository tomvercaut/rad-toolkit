plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.jetbrains:annotations:24.1.0")
        implementation("org.dom4j:dom4j:2.1.4")
        implementation("com.fasterxml.jackson.core:jackson-core:2.16.2")
        implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.2")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.2")
        implementation("ch.qos.logback:logback-classic:1.5.3")
        implementation("ch.qos.logback:logback-core:1.5.3")
        implementation("org.slf4j:slf4j-api:2.0.12")
    }

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.10.2")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
