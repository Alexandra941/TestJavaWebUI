package ru.kalashnikova.homework.homework6;

import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

import java.util.UUID;

public class RegistrationTest extends BaseTest {
    @Test
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
