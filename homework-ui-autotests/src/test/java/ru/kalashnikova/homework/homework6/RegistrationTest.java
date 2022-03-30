package ru.kalashnikova.homework.homework6;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

import java.util.UUID;

@DisplayName("Регистрация")
public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Регистрация нового пользователя")
    @Epic("Автоматизация тестирования Web UI на Java")
    @Story("Урок 7. Allure, протоколирование")
    public void registrationTest() {
        String userEmail = UUID.randomUUID() + "@mailforspam.com";
        String password = "1q2w3e4r+Q";

        new MainHeader(webDriver)
                .goToRegistration()
                .insertEmail(userEmail)
                .insertPassword(password)
                .confirmPassword(password)
                .acceptTerms()
                .clickToRegistrationBtn()
                .goToOrderPage()
                .checkIsCurrentPageOrders()
                .checkIsLoginCorrect(userEmail);
    }
}
