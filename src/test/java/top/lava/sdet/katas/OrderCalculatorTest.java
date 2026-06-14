package top.lava.sdet.katas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import top.lava.sdet.katas.OrderCalculator.OrderLine;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для задачи C ({@link OrderCalculator}).
 *
 * <p>Дан один стартовый тест. Допишите тесты на оптовую скидку, скидку заказа,
 * округление, валидацию и граничные значения.
 *
 * <p>Запуск только этих тестов:
 * {@code ./gradlew test --tests "top.lava.sdet.katas.OrderCalculatorTest"}
 */
@Tag("unit")
class OrderCalculatorTest {

    private final OrderCalculator calculator = new OrderCalculator();

    @Test
    @DisplayName("Пустой заказ стоит 0.00")
    void emptyOrderCostsZero() {
        assertThat(calculator.total(List.of())).isEqualByComparingTo("0.00");
    }

    @SuppressWarnings("unused")
    private OrderLine sample() {
        return new OrderLine("sample", new BigDecimal("25.00"), 5);
    }
}
