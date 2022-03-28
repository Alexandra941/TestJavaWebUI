package ru.kalashnikova.homework.homework6.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.kalashnikova.homework.homework6.pages.*;

import java.util.concurrent.TimeUnit;

public class MainHeader extends BaseView {
    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickToLogin() {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//a[text()='Вход']")))
                .build()
                .perform();
        return new LoginPage(webDriver);
    }

    public BasketPage goToBasket() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//li[@class='mini-cart']/a")))
                .build()
                .perform();

        return new BasketPage(webDriver);
    }

    public ProductsPage goToProductsPage() {
        return new Menu(webDriver).goToWomanSweatshirts();
    }

    public FavoritePage goToFavorite() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//li[@class='mini-favorite']/a")))
                .build()
                .perform();

        return new FavoritePage(webDriver);
    }

    public RegistrationPage goToRegistration() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//a[text()='Регистрация']")))
                .build()
                .perform();

        return new RegistrationPage(webDriver);
    }

    public OrderPage goToOrderPage() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//i[@class='flaticon-avatar-m']")))
                .build()
                .perform();

        return new OrderPage(webDriver);
    }
}
