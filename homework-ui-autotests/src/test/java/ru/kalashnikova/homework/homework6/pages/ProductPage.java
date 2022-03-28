package ru.kalashnikova.homework.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getProductName() {
        return webDriver.findElement(By.xpath("//div[@class='summary']/h1")).getText();
    }

    public void addProductToBasket() {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath(".//button[@class='single_add_to_cart_button']")))
                .build()
                .perform();
    }

    public void addProductToFavorite() {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath(".//button[@class='btn-favorite']")))
                .build()
                .perform();
    }
}
