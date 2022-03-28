package ru.kalashnikova.homework.homework6.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kalashnikova.homework.homework6.pages.BaseView;
import ru.kalashnikova.homework.homework6.pages.ProductsPage;

public class Menu extends BaseView {
    public Menu(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductsPage goToWomanSweatshirts() {
        webDriver.findElement(By.xpath("//ul[@class='sela-nav main-menu pull-left']/li[@class='menu-item-has-children item-megamenu']/a")).click();
        webDriver.findElement(By.partialLinkText("Толстовки и свитшоты")).click();
        return new ProductsPage(webDriver);
    }
}
