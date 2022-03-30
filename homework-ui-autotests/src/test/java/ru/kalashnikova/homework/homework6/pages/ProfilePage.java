package ru.kalashnikova.homework.homework6.pages;

import io.qameta.allure.Step;
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

    @Step("Ввод дня {day}")
    public ProfilePage setDay(String day){
        webDriver.findElement(By.name("profile[birthday][day]")).sendKeys(day);
        return this;
    }

    @Step("Ввод месяца {month}")
    public ProfilePage setMonth(String month){
        webDriver.findElement(By.name("profile[birthday][month]")).sendKeys(month);
        return this;
    }

    @Step("Ввод года {year}")
    public ProfilePage setYear(String year){
        webDriver.findElement(By.name("profile[birthday][year]")).clear();
        webDriver.findElement(By.name("profile[birthday][year]")).sendKeys(year);
        return this;
    }

    @Step("Нажатие по кнопке \"Сохранить\"")
    public ProfilePage clickSave(){
        webDriver.findElement(By.xpath(".//button[text()='Сохранить']")).click();
        return this;
    }

    @Step("Проверка уведомления о успешном сохранении данных")
    public ProfilePage checkSaveAlert() {
        Assertions.assertEquals("Информация успешно обновлена", webDriver.findElement(By.id("alert_save")).getText());
        return this;
    }

    @Step("Провекра сохраненного дня {day}")
    public ProfilePage checkDay(String day){
        Select select = new Select(webDriver.findElement(By.name("profile[birthday][day]")));
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        assertEquals(day, selectedOptions.get(selectedOptions.size() - 1).getText());
        return this;
    }

    @Step("Провекра сохраненного месяца {month}")
    public ProfilePage checkMonth(String month){
        Select select = new Select(webDriver.findElement(By.name("profile[birthday][month]")));
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        assertEquals(month, selectedOptions.get(selectedOptions.size() - 1).getText());
        return this;
    }

    @Step("Провекра сохраненного года {year}")
    public ProfilePage checkYear(String year){
        assertEquals(year, webDriver.findElement(By.name("profile[birthday][year]")).getAttribute("value"));
        return this;
    }
}
