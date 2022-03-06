package ru.kalashnikova.homework.homework5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kalashnikova.homework.homework3.Utils.SelaUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AddToFavoriteTest extends BaseTest {
    @Test
    public void addToFavoriteTest() throws InterruptedException {
        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[text()='Вход']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SelaUtil.Login(webDriver, "hw1.4@mailforspam.com", "1q2w3e4r+Q");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//li[@class='mini-favorite']/a")).click();

        assertEquals("Сейчас у вас ничего нет в «Избранном»",
                     webDriver.findElement(By.xpath("//div[@class='text-center margin-top-60 margin-bottom-55']/h2")).getText());

        webDriver.findElement(By.xpath("//ul[@class='sela-nav main-menu pull-left']/li[@class='menu-item-has-children item-megamenu']/a")).click();
        webDriver.findElement(By.partialLinkText("Толстовки и свитшоты")).click();

        WebElement productContainer = new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//ul[@class='products lines-space-30 desktop-columns-3 tablet-columns-3 mobile-columns-3 ts-columns-2']"))));
        assertNotNull(productContainer);

        List<WebElement> products = productContainer.findElements(By.xpath("//li[@class='product-item product-item_sizes ']"));
        assertNotNull(products);
        assertFalse(products.isEmpty());

        WebElement product = products.get(0);
        String productName = product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")).getText();
        product.findElement(By.xpath(".//button[@class='btn-favorite']")).click();
        product = null;
        webDriver.findElement(By.xpath("//li[@class='mini-favorite']/a")).click();

        List<WebElement> favoriteProducts = webDriver.findElements(By.xpath("//div[@id='product-list']/ul/li"));
        assertFalse(favoriteProducts == null || favoriteProducts.isEmpty());
        assertEquals(1, favoriteProducts.size());
        product = favoriteProducts.get(0);
        assertEquals(productName, product.findElement(By.xpath("//span[@class='product-name text-uppercase name_products_span']/a")).getText());
        product.findElement(By.xpath(".//button[@class='btn-favorite btn-favorite_active']")).click();

        assertEquals("Сейчас у вас ничего нет в «Избранном»",
                webDriver.findElement(By.xpath("//div[@class='text-center margin-top-60 margin-bottom-55']/h2")).getText());
    }
}
