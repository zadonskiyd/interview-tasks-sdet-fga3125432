package top.lava.sdet.katas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Задача C («Деньги / бизнес-правила»).
 *
 * <p>Реализуйте {@link #total(List)} — расчёт итоговой суммы заказа со скидками.
 * Все денежные вычисления — через {@link BigDecimal} (не double/float).
 *
 * <h2>Правила</h2>
 * <ol>
 *   <li>Стоимость строки = {@code unitPrice × quantity}.</li>
 *   <li>Оптовая скидка: если {@code quantity >= 5}, на эту строку −10%.</li>
 *   <li>Скидка на заказ: если сумма всех строк (после оптовых скидок) ≥ 100.00,
 *       то на весь заказ дополнительно −5%.</li>
 *   <li>Итог округляется до 2 знаков по правилу HALF_UP.</li>
 *   <li>Валидация ({@link IllegalArgumentException}): {@code quantity <= 0}
 *       или {@code unitPrice < 0}.</li>
 *   <li>Пустой список → {@code 0.00}.</li>
 * </ol>
 *
 * <h2>Пример</h2>
 * <pre>
 *   строка: unitPrice=25.00, quantity=5
 *     базовая стоимость:        25.00 × 5 = 125.00
 *     оптовая скидка 10%:        125.00 × 0.90 = 112.50
 *     скидка заказа 5% (≥100):   112.50 × 0.95 = 106.875
 *     итог (HALF_UP, 2 знака):   106.88
 * </pre>
 */
public class OrderCalculator {

    /**
     * Строка заказа.
     *
     * @param name      название позиции
     * @param unitPrice цена за единицу
     * @param quantity  количество
     */
    public record OrderLine(String name, BigDecimal unitPrice, int quantity) {
        public OrderLine {
            Objects.requireNonNull(name, "name не может быть null");
            Objects.requireNonNull(unitPrice, "unitPrice не может быть null");
        }
    }

    public BigDecimal total(List<OrderLine> lines) {
        // TODO: реализуйте расчёт согласно javadoc.
        throw new UnsupportedOperationException("Не реализовано — это часть задания.");
    }
}
