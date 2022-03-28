package ru.kalashnikova.homework.homework6.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfilePage setDay(String day){
        webDriver.findElement(By.name("profile[birthday][day]")).sendKeys(day);
        return this;
    }

    public ProfilePage setMonth(String month){
        webDriver.findElement(By.name("profile[birthday][month]")).sendKeys(month);
        return this;
    }

    public ProfilePage setYear(String year){
        webDriver.findElement(By.name("profile[birthday][year]")).clear();
        webDriver.findElement(By.name("profile[birthday][year]")).sendKeys(year);
        return this;
    }

    public ProfilePage clickSave(){
        webDriver.findElement(By.xpath(".//button[text()='Сохранить']")).click();
        return this;
    }

    public ProfilePage checkSaveAlert() {
        Assertions.assertEquals("Информация успешно обновлена", webDriver.findElement(By.id("alert_save")).getText());
        return this;
    }

    public ProfilePage checkDay(String day){
        Select select = new Select(webDriver.findElement(By.name("profile[birthday][day]")));
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        assertEquals(day, selectedOptions.get(selectedOptions.size() - 1).getText());
        return this;
    }

    public ProfilePage checkMonth(String month){
        Select select = new Select(webDriver.findElement(By.name("profile[birthday][month]")));
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        assertEquals(month, selectedOptions.get(selectedOptions.size() - 1).getText());
        return this;
    }

    public ProfilePage checkYear(String year){
        assertEquals(year, webDriver.findElement(By.name("profile[birthday][year]")).getAttribute("value"));
        return this;
    }
}
