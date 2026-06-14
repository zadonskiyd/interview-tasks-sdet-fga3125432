package top.lava.sdet.ui.pages;

import com.codeborne.selenide.SelenideElement;

/**
 * Page Object оформления заказа (шаги checkout).
 *
 * <p>ЗАГОТОВКА (нужна для сценария 2). Объявите локаторы и допишите методы
 * по образцу {@link LoginPage}.
 */
public class CheckoutPage {

    /** Шаг 1: заполнить данные покупателя и продолжить. */
    public CheckoutPage fillInfo(String firstName, String lastName, String postalCode) {
        // TODO: объявите локаторы полей и кнопки continue, заполните и продолжите.
        throw new UnsupportedOperationException("Реализуйте fillInfo.");
    }

    /** Шаг 2: завершить оформление заказа. */
    public CheckoutPage finish() {
        // TODO: объявите локатор кнопки finish и нажмите её.
        throw new UnsupportedOperationException("Реализуйте finish.");
    }

    /** Заголовок страницы подтверждения заказа. */
    public SelenideElement completeHeader() {
        // TODO: объявите локатор заголовка подтверждения и верните его.
        throw new UnsupportedOperationException("Реализуйте completeHeader.");
    }
}
