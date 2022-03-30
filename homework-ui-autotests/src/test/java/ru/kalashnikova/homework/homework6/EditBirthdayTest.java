package ru.kalashnikova.homework.homework6;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;

@DisplayName("Редактирование даты рождения пользователя")
public class EditBirthdayTest extends BaseTest {

    @Test
    @DisplayName("Успешное редактирование даты рождения пользователя")
    @Epic("Автоматизация тестирования Web UI на Java")
    @Story("Урок 7. Allure, протоколирование")
    public void editBirthdayTest() {
        String day = "13";
        String month = "Май";
        String year = "1991";

        new MainPage(webDriver)
                .getHeader()
                .clickToLogin()
                .login()
                .goToOrderPage()
                .getPersonalAreaMenu()
                .toToProfilePage()
                .setDay(day)
                .setMonth(month)
                .setYear(year)
                .clickSave()
                .checkSaveAlert()
                .checkDay(day)
                .checkMonth(month)
                .checkYear(year);
    }
}
