package ru.kalashnikova.homework.homework6;

import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;

public class EditBirthdayTest extends BaseTest {
    @Test
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
