package ru.kalashnikova.homework.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FavoritePage extends BasePage {
    public FavoritePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader checkFavoriteIsEmpty(){
        assertEquals("Сейчас у вас ничего нет в «Избранном»",
                webDriver.findElement(By.xpath("//div[@class='text-center margin-top-60 margin-bottom-55']/h2")).getText());

        return new MainHeader(webDriver);
    }

    public FavoritePage checkProductInFavorite(String productName) {
        WebElement product = getProduct();

        String name = product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")).getText();
        assertEquals(productName, name);

        return this;
    }

    public FavoritePage clearFavorite() {
        getProduct().findElement(By.xpath(".//button[@class='btn-favorite btn-favorite_active']")).click();
        return this;
    }

    private WebElement getProduct() {
        return webDriver
                .findElements(By.xpath("//div[@id='product-list']/ul/li"))
                .get(0);
    }
}
