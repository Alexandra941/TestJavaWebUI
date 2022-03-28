package ru.kalashnikova.homework.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

public class LoginPage extends BasePage {
    private WebElement authPopup;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        authPopup = webDriver.findElement(By.xpath("//div[@class='wa-login-form-fields js-login-form-fields-block']"));
    }

    public MainHeader login() {
        String login = "hw1.4@mailforspam.com";
        String password = "1q2w3e4r+Q";
        OrderPage orderPage = login(login, password);

        return new MainHeader(orderPage.webDriver);
    }

    public OrderPage login(String login, String password) {
        insertLogin(login);
        insertPassword(password);
        clickSubmitBtn();

        return new OrderPage(webDriver);
    }

    private LoginPage insertLogin(String login){
        authPopup.findElement(By.name("login")).sendKeys(login);
        return this;
    }

    private LoginPage insertPassword(String password){
        authPopup.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    private LoginPage clickSubmitBtn() {
        authPopup.findElement(By.xpath("//input[@class='wa-login-submit']")).click();
        return this;
    }
}
