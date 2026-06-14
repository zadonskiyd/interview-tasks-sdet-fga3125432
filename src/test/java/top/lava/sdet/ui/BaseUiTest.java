package top.lava.sdet.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.MutableCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Базовый класс для UI/E2E-тестов на Selenide.
 *
 * <p>Конфигурация управляется через системные свойства (см. README):
 * <ul>
 *   <li>{@code -Dselenide.remote=http://localhost:4444/wd/hub} — гонять тесты в Selenoid;
 *       если не задано — запускается локальный браузер;</li>
 *   <li>{@code -Dselenide.browser=chrome} (по умолчанию chrome);</li>
 *   <li>{@code -Dselenide.headless=true|false};</li>
 *   <li>{@code -Dselenide.baseUrl=https://www.saucedemo.com};</li>
 *   <li>{@code -Dselenoid.enableVnc=true} / {@code -Dselenoid.enableVideo=true}.</li>
 * </ul>
 */
public abstract class BaseUiTest {

    @BeforeAll
    static void configureSelenide() {
        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = 30_000;
        Configuration.baseUrl = System.getProperty("selenide.baseUrl", "https://www.saucedemo.com");

        // Скриншоты и html-страница сохраняются при падении (build/reports/tests).
        Configuration.screenshots = true;
        Configuration.savePageSource = true;

        String browserVersion = System.getProperty("selenide.browserVersion");
        if (browserVersion != null && !browserVersion.isBlank()) {
            Configuration.browserVersion = browserVersion;
        }

        String remote = System.getProperty("selenide.remote");
        boolean useRemote = remote != null && !remote.isBlank();

        if (useRemote) {
            // Запуск в Selenoid (или другом Selenium Grid).
            Configuration.remote = remote;
            Configuration.headless = false; // в Selenoid headless не нужен — браузер уже в контейнере

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC",
                    Boolean.parseBoolean(System.getProperty("selenoid.enableVnc", "true")));
            selenoidOptions.put("enableVideo",
                    Boolean.parseBoolean(System.getProperty("selenoid.enableVideo", "false")));

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("selenoid:options", selenoidOptions);
            Configuration.browserCapabilities = capabilities;
        } else {
            // Локальный браузер.
            Configuration.headless =
                    Boolean.parseBoolean(System.getProperty("selenide.headless", "true"));
        }
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
