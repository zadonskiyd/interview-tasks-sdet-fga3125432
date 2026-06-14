# SDET — interview

Стек:

- **Java / Kotlin**
- **JUnit 5** (Jupiter)
- **Selenide** (UI / E2E)
- **Selenoid** (запуск браузеров в Docker — **опционально**)
- **Gradle** (Gradle Wrapper уже в проекте)

---

## Требования к окружению

- **JDK 17+** (если в системе нет — Gradle сам скачает нужный JDK через toolchain)
- **Docker** — только если хотите Selenoid (необязательно)
- Git

Gradle ставить не нужно — используйте Wrapper (`./gradlew` или `gradlew.bat`).

---

## Структура проекта

```
.
├── build.gradle.kts
├── docker-compose.yml          # Selenoid + Selenoid UI (опционально)
├── config/browsers.json        # браузеры Selenoid
└── src/
    ├── main/java/top/lava/sdet/katas/
    │   ├── Palindromes.java        # Часть 1, вариант A
    │   ├── RomanNumerals.java      # Часть 1, вариант B
    │   └── OrderCalculator.java    # Часть 1, вариант C
    └── test/java/top/lava/sdet/
        ├── SetupSmokeTest.java     # дымовой тест (проходит из коробки)
        ├── katas/                  # стартовые unit-тесты к вариантам A/B/C
        └── ui/
            ├── BaseUiTest.java     # конфигурация Selenide (+ опц. Selenoid)
            ├── pages/              # готовые Page Object'ы (Login/Products/Cart/Checkout)
            └── SauceDemoTest.java  # UI-сценарии на выбор
```

---

## Быстрый старт

### 1. Проверка окружения

```bash
./gradlew test --tests "top.lava.sdet.katas.SetupSmokeTest"
```

### 2. Часть 1 — программирование + unit-тесты (одна задача на выбор)

```bash
./gradlew test --tests "top.lava.sdet.katas.PalindromesTest"
./gradlew test --tests "top.lava.sdet.katas.RomanNumeralsTest"
./gradlew test --tests "top.lava.sdet.katas.OrderCalculatorTest"
```

Запустить все unit-тесты сразу: `./gradlew unitTest`

### 3. Часть 2 — UI-тест на Selenide (один сценарий на выбор)

Локальный браузер (по умолчанию Chrome headless — нужен установленный Chrome):

```bash
./gradlew uiTest --tests "top.lava.sdet.ui.SauceDemoTest"
./gradlew uiTest --tests "top.lava.sdet.ui.SauceDemoTest" -Dselenide.headless=false
```

---

## Опционально: запуск UI через Selenoid

```bash
docker pull selenoid/vnc_chrome:127.0     # один раз
docker compose up -d                       # Selenoid + UI (http://localhost:8080)
./gradlew uiTest -Dselenide.remote=http://localhost:4444/wd/hub
docker compose down
```

---

## Параметры запуска UI (системные свойства)

| Свойство                 | По умолчанию                | Описание                                           |
|--------------------------|-----------------------------|----------------------------------------------------|
| `-Dselenide.remote`      | (пусто = локальный браузер) | URL Selenoid, напр. `http://localhost:4444/wd/hub` |
| `-Dselenide.browser`     | `chrome`                    | `chrome` / `firefox`                               |
| `-Dselenide.headless`    | `true`                      | headless для локального браузера                   |
| `-Dselenide.baseUrl`     | `https://www.saucedemo.com` | базовый URL приложения                             |
| `-Dselenoid.enableVnc`   | `true`                      | включить VNC в Selenoid                            |
| `-Dselenoid.enableVideo` | `false`                     | запись видео в Selenoid                            |

> Отчёты о тестах: `build/reports/tests/test/index.html`.
> Скриншоты/HTML при падении UI-тестов сохраняются туда же.
