package ru.kalashnikova.homework.homework6;

import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;

public class LoginTest extends BaseTest {
    @Test
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
