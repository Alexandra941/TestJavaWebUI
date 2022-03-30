package ru.kalashnikova.homework.homework6;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;
import ru.kalashnikova.homework.homework6.pages.ProductPage;

@DisplayName("Страница \"Корзина\"")
public class AddToBasketTest extends BaseTest {

    @Test
    @DisplayName("Успешное добавление товара в корзину")
    @Epic("Автоматизация тестирования Web UI на Java")
    @Story("Урок 7. Allure, протоколирование")
    public void addToBasketTest() throws InterruptedException {
        ProductPage productPage = new MainPage(webDriver)
                .getHeader()
                .clickToLogin()
                .login()
                .goToBasket()
                .checkBasketIsEmpty()
                .goToProductsPage()
                .openProductPage();

        String productName = productPage.getProductName();
        productPage.addProductToBasket();

        new MainPage(webDriver)
                .getHeader()
                .goToBasket()
                .checkProductInBasket(productName)
                .clearBasket()
                .checkBasketIsEmpty();
    }
}
