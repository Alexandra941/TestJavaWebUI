package ru.kalashnikova.homework.homework5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kalashnikova.homework.homework3.Utils.SelaUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AddToBasketTest extends BaseTest {
    @Test
    public void addToBasketTest() throws InterruptedException {
        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[text()='Вход']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SelaUtil.Login(webDriver, "hw1.4@mailforspam.com", "1q2w3e4r+Q");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//li[@class='mini-cart']/a")).click();

        assertEquals("Корзина пуста",
                     webDriver.findElement(By.xpath("//div[@class='container-fluid']/div/h2")).getText());

        webDriver.findElement(By.xpath("//ul[@class='sela-nav main-menu pull-left']/li[@class='menu-item-has-children item-megamenu']/a")).click();
        webDriver.findElement(By.partialLinkText("Толстовки и свитшоты")).click();

        WebElement productContainer = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//ul[@class='products lines-space-30 desktop-columns-3 tablet-columns-3 mobile-columns-3 ts-columns-2']"))));
        assertNotNull(productContainer);

        List<WebElement> products = productContainer.findElements(By.xpath("//li[@class='product-item product-item_sizes ']"));
        assertNotNull(products);
        assertFalse(products.isEmpty());

        WebElement product = products.get(0);
        String productName = product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")).getText();

        product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")).click();
        Thread.sleep(1000);
        product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")).click();

        webDriver.findElement(By.xpath(".//button[@class='single_add_to_cart_button']")).click();
        Thread.sleep(1000);
        assertEquals("Перейти в корзину", webDriver.findElement(By.xpath("//button[@class='single_add_to_cart_button alt']")).getText());
        product = null;

        webDriver.findElement(By.xpath("//li[@class='mini-cart']/a")).click();

        List<WebElement> productsInBasket = webDriver.findElements(By.xpath("//table[@class='shop_table cart']/tbody/tr"));
        assertFalse(productsInBasket == null || productsInBasket.isEmpty());
        assertEquals(1, productsInBasket.size());
        product = productsInBasket.get(0);

        String name = product.findElement(By.xpath("//td[@class='product-name']/a")).getText();
        assertEquals(productName, name.substring(0, name.indexOf('\n')));

        product.findElement(By.xpath("//td[@class='product-remove']/a")).click();

        Thread.sleep(1000);
        assertEquals("Корзина пуста",
                webDriver.findElement(By.xpath("//div[@class='container-fluid']/div/h2")).getText());
    }
}
