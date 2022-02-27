package ru.kalashnikova.homework.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import ru.kalashnikova.homework.homework3.Utils.SelaUtil;

import java.util.concurrent.TimeUnit;

public class EditBirthday {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[text()='Вход']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SelaUtil.Login(webDriver, "hw1.4@mailforspam.com", "1q2w3e4r+Q");

        WebElement menuControl = webDriver.findElement(By.xpath("//div[@class='widgetcontent_collapse collapse']/div/ul"));
        menuControl.findElement(By.partialLinkText("Профиль")).click();

        webDriver.findElement(By.name("profile[birthday][day]")).sendKeys("13");
        webDriver.findElement(By.name("profile[birthday][month]")).sendKeys("Март");
        webDriver.findElement(By.name("profile[birthday][year]")).clear();
        webDriver.findElement(By.name("profile[birthday][year]")).sendKeys("1998");

        webDriver.findElement(By.xpath(".//button[text()='Сохранить']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(webDriver.findElement(By.id("alert_save")).getText());

        //webDriver.quit();
    }
}
