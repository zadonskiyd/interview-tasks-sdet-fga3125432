package top.lava.sdet.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object страницы логина https://www.saucedemo.com/.
 *
 * <p>Это пример реализации паттерна Page Object. Используйте его как образец
 * и при необходимости дополняйте/добавляйте новые Page Object'ы для своих сценариев.
 */
public class LoginPage {

    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test='error']");

    public LoginPage openPage() {
        open("/");
        return this;
    }

    public ProductsPage loginAs(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return new ProductsPage();
    }

    public SelenideElement errorMessage() {
        return errorMessage;
    }
}
