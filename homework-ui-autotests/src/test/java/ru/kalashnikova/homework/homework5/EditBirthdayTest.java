package ru.kalashnikova.homework.homework5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.kalashnikova.homework.homework3.Utils.SelaUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class EditBirthdayTest extends BaseTest {
    @Test
    public void editBirthdayTest() {
        webDriver.get("https://www.sela.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[text()='Вход']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SelaUtil.Login(webDriver, "hw1.4@mailforspam.com", "1q2w3e4r+Q");

        WebElement menuControl = webDriver.findElement(By.xpath("//div[@class='widgetcontent_collapse collapse']/div/ul"));
        menuControl.findElement(By.partialLinkText("Профиль")).click();

        String day = "15";
        String month = "Март";
        String year = "1998";

        webDriver.findElement(By.name("profile[birthday][day]")).sendKeys(day);
        webDriver.findElement(By.name("profile[birthday][month]")).sendKeys(month);
        webDriver.findElement(By.name("profile[birthday][year]")).clear();
        webDriver.findElement(By.name("profile[birthday][year]")).sendKeys(year);

        webDriver.findElement(By.xpath(".//button[text()='Сохранить']")).click();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals("Информация успешно обновлена", webDriver.findElement(By.id("alert_save")).getText());

        Select select = new Select(webDriver.findElement(By.name("profile[birthday][day]")));
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        assertNotNull(selectedOptions);
        assertFalse(selectedOptions.isEmpty());

        if (selectedOptions.size() > 1) {
            assertEquals(day, selectedOptions.get(selectedOptions.size() - 1).getText());
        }
        else {
            assertEquals(day, selectedOptions.get(0).getText());
        }

        select = new Select(webDriver.findElement(By.name("profile[birthday][month]")));
        selectedOptions = select.getAllSelectedOptions();

        if (selectedOptions.size() > 1) {
            assertEquals(month, selectedOptions.get(selectedOptions.size() - 1).getText());
        }
        else {
            assertEquals(month, selectedOptions.get(0).getText());
        }

        assertEquals(year, webDriver.findElement(By.name("profile[birthday][year]")).getAttribute("value"));
    }
}
