package top.lava.sdet.ui.pages;

import com.codeborne.selenide.ElementsCollection;

/**
 * Page Object корзины (/cart.html).
 *
 * <p>ЗАГОТОВКА (нужна для сценария 2). Объявите локаторы и допишите методы
 * по образцу {@link LoginPage}.
 */
public class CartPage {

    /** Позиции в корзине. */
    public ElementsCollection cartItems() {
        // TODO: объявите локатор позиций корзины и верните коллекцию.
        throw new UnsupportedOperationException("Реализуйте cartItems.");
    }

    /** Перейти к оформлению заказа. */
    public CheckoutPage checkout() {
        // TODO: объявите локатор кнопки checkout и выполните переход.
        throw new UnsupportedOperationException("Реализуйте checkout.");
    }
}
