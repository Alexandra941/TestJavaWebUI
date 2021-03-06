package ru.kalashnikova.homework.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader checkBasketIsEmpty(){
        assertEquals("Корзина пуста",
                webDriver.findElement(By.xpath("//div[@class='container-fluid']/div/h2")).getText());

        return new MainHeader(webDriver);
    }

    public BasketPage checkProductInBasket(String productName) {
        WebElement product = getProduct();

        String name = product.findElement(By.xpath("//td[@class='product-name']/a")).getText();
        assertEquals(productName, name.substring(0, name.indexOf('\n')));

        return this;
    }

    public BasketPage clearBasket() {
        getProduct().findElement(By.xpath("//td[@class='product-remove']/a")).click();
        return this;
    }

    private WebElement getProduct() {
        return webDriver
                .findElements(By.xpath("//table[@class='shop_table cart']/tbody/tr"))
                .get(0);
    }
}
