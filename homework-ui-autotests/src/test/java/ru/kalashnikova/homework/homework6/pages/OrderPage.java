package ru.kalashnikova.homework.homework6.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kalashnikova.homework.homework6.pages.blocks.PersonalAreaMenu;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderPage checkIsCurrentPageOrders(){
        Assertions.assertEquals("Мои заказы", webDriver.findElement(By.xpath("//div[@class='col-sm-8 col-md-9 main-content']/h2")).getText());
        return this;
    }

    public OrderPage checkIsLoginCorrect(String login) {
        Assertions.assertEquals(login, webDriver.findElement(By.xpath("//div[@class='widgettitle_info hidden-xs']/div")).getText());
        return this;
    }

    public PersonalAreaMenu getPersonalAreaMenu() {
        return new PersonalAreaMenu(webDriver);
    }
}
