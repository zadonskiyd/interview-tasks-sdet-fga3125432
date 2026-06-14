package top.lava.sdet.ui;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import top.lava.sdet.ui.pages.LoginPage;
import top.lava.sdet.ui.pages.ProductsPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;

/**
 * UI/E2E часть (Selenide) для демо-магазина https://www.saucedemo.com/.
 *
 * <p>В очном формате достаточно реализовать <b>ОДИН</b> сценарий из приведённых
 * ниже (на выбор). Ниже дан рабочий пример (успешный логин).
 *
 * <p>Помимо самого теста нужно дописать Page Object под ваш сценарий: в пакете
 * {@code ...ui.pages} класс {@code LoginPage} реализован полностью как образец,
 * а нужные методы в {@code ProductsPage}/{@code CartPage}/{@code CheckoutPage} —
 * это заготовки (объявите локаторы и допишите тела по образцу LoginPage).
 *
 * <p>По умолчанию тесты идут в локальном headless-браузере:
 * <pre>./gradlew uiTest --tests "top.lava.sdet.ui.SauceDemoTest"</pre>
 * Опционально — через Selenoid (см. README):
 * <pre>./gradlew uiTest -Dselenide.remote=http://localhost:4444/wd/hub</pre>
 *
 * <p>Учётные данные: {@code standard_user} / {@code secret_sauce}.
 */
@Tag("ui")
class SauceDemoTest extends BaseUiTest {

    // ----- РАБОЧИЙ ПРИМЕР (трогать не нужно) -----------------------------------
    @Test
    @DisplayName("[пример] Успешный логин показывает каталог товаров")
    void successfulLoginShowsProducts() {
        ProductsPage products = new LoginPage()
                .openPage()
                .loginAs("standard_user", "secret_sauce");

        products.title().shouldHave(text("Products"));
        products.inventoryItems().shouldHave(sizeGreaterThan(0));
    }

    // ----- ВЫБЕРИТЕ И РЕАЛИЗУЙТЕ ОДИН ИЗ СЦЕНАРИЕВ (снимите @Disabled) ----------

    @Test
    @Disabled("Сценарий 1: реализуйте и уберите @Disabled")
    @DisplayName("[сценарий 1] Добавление товара в корзину обновляет счётчик")
    void addingProductUpdatesCartBadge() {
        throw new UnsupportedOperationException("Реализуйте сценарий 1.");
    }

    @Test
    @Disabled("Сценарий 2: реализуйте и уберите @Disabled")
    @DisplayName("[сценарий 2] Полный checkout завершается подтверждением заказа")
    void checkoutHappyPath() {
        throw new UnsupportedOperationException("Реализуйте сценарий 2.");
    }

    @Test
    @Disabled("Сценарий 3: реализуйте и уберите @Disabled")
    @DisplayName("[сценарий 3] Сортировка по цене (low to high) упорядочивает товары")
    void sortingByPriceLowToHigh() {
        throw new UnsupportedOperationException("Реализуйте сценарий 3.");
    }
}
