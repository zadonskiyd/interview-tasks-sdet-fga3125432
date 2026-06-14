plugins {
    java
}

group = "top.lava.sdet"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    toolchain {
        // Минимально требуемая версия JDK. Допускается 17+.
        languageVersion = JavaLanguageVersion.of(17)
    }
}

dependencies {
    // JUnit 5 (Jupiter)
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Selenide (UI / E2E)
    testImplementation("com.codeborne:selenide:7.4.3")

    // Удобные ассерты
    testImplementation("org.assertj:assertj-core:3.26.0")

    // Логирование (чтобы видеть, что делает Selenide/WebDriver)
    testImplementation("org.slf4j:slf4j-simple:2.0.13")
}

tasks.test {
    useJUnitPlatform()

    // Прокидываем системные свойства из командной строки в тестовую JVM.
    // Пример запуска против Selenoid:
    //   ./gradlew test -Dselenide.remote=http://localhost:4444/wd/hub -Dselenoid.enableVnc=true
    listOf(
        "selenide.remote",
        "selenide.browser",
        "selenide.browserVersion",
        "selenide.headless",
        "selenide.baseUrl",
        "selenoid.enableVnc",
        "selenoid.enableVideo",
    ).forEach { key ->
        System.getProperty(key)?.let { systemProperty(key, it) }
    }

    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = false
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

// Отдельная задача, чтобы запускать ТОЛЬКО unit-тесты (без UI).
tasks.register<Test>("unitTest") {
    description = "Запускает только unit-тесты (пакет ...cart), без UI."
    group = "verification"
    useJUnitPlatform {
        includeTags("unit")
    }
    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

// Отдельная задача для UI-тестов.
tasks.register<Test>("uiTest") {
    description = "Запускает только UI/E2E тесты (Selenide)."
    group = "verification"
    useJUnitPlatform {
        includeTags("ui")
    }
    listOf(
        "selenide.remote",
        "selenide.browser",
        "selenide.browserVersion",
        "selenide.headless",
        "selenide.baseUrl",
        "selenoid.enableVnc",
        "selenoid.enableVideo",
    ).forEach { key ->
        System.getProperty(key)?.let { systemProperty(key, it) }
    }
    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
