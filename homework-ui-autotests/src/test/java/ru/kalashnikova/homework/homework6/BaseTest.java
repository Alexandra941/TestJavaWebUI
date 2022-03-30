package ru.kalashnikova.homework.homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.kalashnikova.homework.homework6.listeners.AllureListener;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class BaseTest {
    protected EventFiringWebDriver webDriver;

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=true");

        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
        webDriver.register(new AllureListener());
        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    @AfterEach
    void tearDown() {
        step("Логи браузера", () -> {
            webDriver.manage().logs().get(LogType.BROWSER)
                    .forEach(log -> addAttachment("logs", log.getMessage()));
        });
        webDriver.quit();
    }
}
