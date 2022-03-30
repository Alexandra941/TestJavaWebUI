package ru.kalashnikova.homework.homework6.pages.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.kalashnikova.homework.homework6.pages.*;

import java.util.concurrent.TimeUnit;

public class MainHeader extends BaseView {
    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Переход на страницу авторизации")
    public LoginPage clickToLogin() {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//a[text()='Вход']")))
                .build()
                .perform();
        return new LoginPage(webDriver);
    }

    @Step("Переход на страницу корзины")
    public BasketPage goToBasket() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//li[@class='mini-cart']/a")))
                .build()
                .perform();

        return new BasketPage(webDriver);
    }

    @Step("Переход на страницу товаров")
    public ProductsPage goToProductsPage() {
        return new Menu(webDriver).goToWomanSweatshirts();
    }

    @Step("Переход на страницу избранных товаров")
    public FavoritePage goToFavorite() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//li[@class='mini-favorite']/a")))
                .build()
                .perform();

        return new FavoritePage(webDriver);
    }

    @Step("Переход на страницу регистрации")
    public RegistrationPage goToRegistration() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//a[text()='Регистрация']")))
                .build()
                .perform();

        return new RegistrationPage(webDriver);
    }

    @Step("Переход на страницу заказов")
    public OrderPage goToOrderPage() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//i[@class='flaticon-avatar-m']")))
                .build()
                .perform();

        return new OrderPage(webDriver);
    }
}
