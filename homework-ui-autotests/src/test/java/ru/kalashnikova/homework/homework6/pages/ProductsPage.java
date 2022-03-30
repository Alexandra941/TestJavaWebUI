package ru.kalashnikova.homework.homework6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие страницы продукта")
    public ProductPage openProductPage() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement product = webDriver.findElement(By.xpath("//ul[@class='products lines-space-30 desktop-columns-3 tablet-columns-3 mobile-columns-3 ts-columns-2']"))
                .findElements(By.xpath("//li[@class='product-item product-item_sizes ']"))
                .get(0);

        //doubleClick не срабатывает
        new Actions(webDriver)
                .click(product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")))
                .build()
                .perform();
        new Actions(webDriver)
                .click(product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")))
                .build()
                .perform();
        return new ProductPage(webDriver);
    }
}
