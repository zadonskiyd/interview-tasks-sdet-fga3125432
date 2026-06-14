package top.lava.sdet.katas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для задачи B ({@link RomanNumerals}).
 *
 * <p>Дан один стартовый тест. Допишите тесты, покрывающие «вычитающие» формы,
 * граничные значения (1, 3999) и выход за диапазон.
 *
 * <p>Запуск только этих тестов:
 * {@code ./gradlew test --tests "top.lava.sdet.katas.RomanNumeralsTest"}
 */
@Tag("unit")
class RomanNumeralsTest {

    private final top.lava.sdet.katas.RomanNumerals roman = new top.lava.sdet.katas.RomanNumerals();

    @Test
    @DisplayName("Базовый пример: 58 -> LVIII")
    void convertsCompositeNumber() {
        assertThat(roman.toRoman(58)).isEqualTo("LVIII");
    }
}
