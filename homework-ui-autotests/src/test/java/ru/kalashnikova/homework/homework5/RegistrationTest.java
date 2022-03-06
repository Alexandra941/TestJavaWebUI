package ru.kalashnikova.homework.homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import ru.kalashnikova.homework.homework3.Utils.SelaUtil;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        String login = "hw1.4@mailforspam.com";
        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[text()='Вход']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SelaUtil.Login(webDriver, "hw1.4@mailforspam.com", "1q2w3e4r+Q");

        Assertions.assertEquals("Мои заказы", webDriver.findElement(By.xpath("//div[@class='col-sm-8 col-md-9 main-content']/h2")).getText());
        Assertions.assertEquals(login, webDriver.findElement(By.xpath("//div[@class='widgettitle_info hidden-xs']/div")).getText());
        webDriver.quit();
    }
}
