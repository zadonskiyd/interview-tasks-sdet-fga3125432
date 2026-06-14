package top.lava.sdet.katas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Дымовой тест — проверяет, что окружение (JDK, Gradle, JUnit 5) настроено.
 * Этот тест НЕ требует ничего реализовывать и должен проходить «из коробки»:
 * <pre>./gradlew test --tests "top.lava.sdet.katas.SetupSmokeTest"</pre>
 */
class SetupSmokeTest {

    @Test
    @DisplayName("Окружение настроено: JUnit 5 работает")
    void environmentIsReady() {
        assertThat(1 + 1).isEqualTo(2);
    }
}
