package top.lava.sdet.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Page Object страницы со списком товаров (после успешного логина).
 *
 * <p>Часть методов уже реализована (используются в примере логина), часть —
 * ЗАГОТОВКИ для вашего сценария: объявите локаторы и допишите тела методов
 * по образцу {@link LoginPage}. Реализуйте только то, что нужно вашему сценарию.
 */
public class ProductsPage {

    private final SelenideElement title = $(".title");
    private final SelenideElement sortDropdown = $(".product_sort_container");
    private final ElementsCollection inventoryItems = $$(".inventory_item");

    public SelenideElement title() {
        return title;
    }

    public ElementsCollection inventoryItems() {
        return inventoryItems;
    }

    /**
     * Сортировка: значения value — "az", "za", "lohi", "hilo".
     * <p>
     * Реализация предоставлена. Нюанс: saucedemo использует React-управляемый
     * {@code <select>}, и обычный {@code selectOptionByValue} меняет значение,
     * но не всегда триггерит обработчик onChange. Поэтому выставляем значение
     * нативным сеттером и явно отправляем событие change.
     */
    public ProductsPage sortBy(String value) {
        executeJavaScript(
                "const el = arguments[0];"
                        + "const setter = Object.getOwnPropertyDescriptor("
                        + "window.HTMLSelectElement.prototype, 'value').set;"
                        + "setter.call(el, arguments[1]);"
                        + "el.dispatchEvent(new Event('change', { bubbles: true }));",
                sortDropdown, value);
        return this;
    }

    // ----- ЗАГОТОВКИ: реализуйте те методы, что нужны вашему сценарию ----------

    /** Сценарий 1: добавить товар в корзину по названию (например, "Sauce Labs Backpack"). */
    public ProductsPage addToCart(String productName) {
        // TODO: объявите локатор и реализуйте добавление в корзину.
        throw new UnsupportedOperationException("Реализуйте addToCart.");
    }

    /** Сценарий 1: счётчик (badge) количества товаров в корзине. */
    public SelenideElement cartBadge() {
        // TODO: объявите локатор бейджа корзины и верните его.
        throw new UnsupportedOperationException("Реализуйте cartBadge.");
    }

    /** Сценарий 3: цены товаров (для проверки порядка сортировки). */
    public ElementsCollection itemPrices() {
        // TODO: объявите локатор цен и верните коллекцию.
        throw new UnsupportedOperationException("Реализуйте itemPrices.");
    }

    /** Сценарий 2: перейти в корзину. */
    public CartPage openCart() {
        // TODO: объявите локатор ссылки на корзину и выполните переход.
        throw new UnsupportedOperationException("Реализуйте openCart.");
    }
}