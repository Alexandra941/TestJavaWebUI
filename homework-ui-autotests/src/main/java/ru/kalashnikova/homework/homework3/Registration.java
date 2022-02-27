package ru.kalashnikova.homework.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Registration {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[text()='Регистрация']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String userEmail = UUID.randomUUID() + "@mailforspam.com";
        WebElement authPopup = webDriver.findElement(By.xpath("//section[@class='wa-signup-form-fields js-signup-form-fields']"));
        authPopup.findElement(By.name("data[email]")).sendKeys(userEmail);
        authPopup.findElement(By.name("data[password]")).sendKeys("1q2w3e4r+Q");
        authPopup.findElement(By.name("data[password_confirm]")).sendKeys("1q2w3e4r+Q");
        authPopup.findElement(By.name("data[terms_accepted]")).click();
        authPopup.findElement(By.xpath("//div[@class='wa-buttons-wrapper']/input")).click();
        webDriver.findElement(By.xpath("//i[@class='flaticon-avatar-m']")).click();

        System.out.println(webDriver.findElement(By.xpath("//div[@class='col-sm-8 col-md-9 main-content']/h2")).getText());
        System.out.println(webDriver.findElement(By.xpath("//div[@class='widgettitle_info hidden-xs']/div")).getText());
        webDriver.quit();
    }
}
