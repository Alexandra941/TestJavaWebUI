package ru.kalashnikova.homework.homework6.pages.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.kalashnikova.homework.homework6.pages.BaseView;
import ru.kalashnikova.homework.homework6.pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class PersonalAreaMenu extends BaseView {
    public PersonalAreaMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Переход на страницу с информацией о пользователе")
    public ProfilePage toToProfilePage() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Actions(webDriver)
                .click(webDriver.findElement(By.partialLinkText("Профиль")))
                .build()
                .perform();
        return new ProfilePage(webDriver);
    }
}
