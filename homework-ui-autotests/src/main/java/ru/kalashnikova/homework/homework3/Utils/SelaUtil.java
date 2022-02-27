package ru.kalashnikova.homework.homework3.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelaUtil {
    public static void Login(WebDriver webDriver, String login, String password) {
        WebElement authPopup = webDriver.findElement(By.xpath("//div[@class='wa-login-form-fields js-login-form-fields-block']"));
        authPopup.findElement(By.name("login")).sendKeys(login);
        authPopup.findElement(By.name("password")).sendKeys(password);
        authPopup.findElement(By.xpath("//input[@class='wa-login-submit']")).click();
    }
}
