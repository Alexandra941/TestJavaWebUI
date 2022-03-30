package ru.kalashnikova.homework.homework6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ввод email адреса {userEmail}")
    public RegistrationPage insertEmail(String userEmail) {
        webDriver.findElement(By.name("data[email]")).sendKeys(userEmail);
        return this;
    }

    @Step("Ввод пароля {password}")
    public RegistrationPage insertPassword(String password) {
        webDriver.findElement(By.name("data[password]")).sendKeys(password);
        return this;
    }

    @Step("Подтверждение пароля {password}")
    public RegistrationPage confirmPassword(String password) {
        webDriver.findElement(By.name("data[password_confirm]")).sendKeys(password);
        return this;
    }

    @Step("Подтверждение согласия с политикой конфиденциальности")
    public RegistrationPage acceptTerms() {
        webDriver.findElement(By.name("data[terms_accepted]")).click();
        return this;
    }

    @Step("Нажатие по кнопке \"Регистрация\"")
    public MainHeader clickToRegistrationBtn() {
        webDriver.findElement(By.xpath("//div[@class='wa-buttons-wrapper']/input")).click();
        return new MainHeader(webDriver);
    }
}
