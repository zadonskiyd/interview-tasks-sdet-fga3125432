package top.lava.sdet.katas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для задачи A ({@link Palindromes}).
 *
 * <p>Дан один стартовый тест. Допишите тесты, покрывающие правила и
 * граничные случаи (регистр, знаки препинания, пустая строка, null и т.д.).
 *
 * <p>Запуск только этих тестов:
 * {@code ./gradlew test --tests "top.lava.sdet.katas.PalindromesTest"}
 */
@Tag("unit")
class PalindromesTest {

    private final Palindromes palindromes = new Palindromes();

    @Test
    @DisplayName("Классический палиндром с пунктуацией")
    void detectsPalindromeIgnoringPunctuationAndCase() {
        assertThat(palindromes.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
    }
}
