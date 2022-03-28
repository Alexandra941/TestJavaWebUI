package ru.kalashnikova.homework.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }


    public RegistrationPage insertEmail(String userEmail) {
        webDriver.findElement(By.name("data[email]")).sendKeys(userEmail);
        return this;
    }

    public RegistrationPage insertPassword(String password) {
        webDriver.findElement(By.name("data[password]")).sendKeys(password);
        return this;
    }

    public RegistrationPage confirmPassword(String password) {
        webDriver.findElement(By.name("data[password_confirm]")).sendKeys(password);
        return this;
    }

    public RegistrationPage acceptTerms() {
        webDriver.findElement(By.name("data[terms_accepted]")).click();
        return this;
    }

    public MainHeader clickToRegistrationBtn() {
        webDriver.findElement(By.xpath("//div[@class='wa-buttons-wrapper']/input")).click();
        return new MainHeader(webDriver);
    }
}
