package ru.kalashnikova.homework.homework6;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;

@DisplayName("Авторизация")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Успешная авторизация под существующим пользователем")
    @Epic("Автоматизация тестирования Web UI на Java")
    @Story("Урок 7. Allure, протоколирование")
    public void loginTest() {
        String login = "hw1.4@mailforspam.com";
        String password = "1q2w3e4r+Q";
        new MainPage(webDriver)
                .getHeader()
                .clickToLogin()
                .login(login, password)
                .checkIsCurrentPageOrders()
                .checkIsLoginCorrect(login);
    }
}
