package ru.kalashnikova.homework.homework6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Получение названия товара")
    public String getProductName() {
        return webDriver.findElement(By.xpath("//div[@class='summary']/h1")).getText();
    }

    @Step("Добавление товара в корзину")
    public void addProductToBasket() {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath(".//button[@class='single_add_to_cart_button']")))
                .build()
                .perform();
    }

    @Step("Добавление товара в избранное")
    public void addProductToFavorite() {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath(".//button[@class='btn-favorite']")))
                .build()
                .perform();
    }
}
