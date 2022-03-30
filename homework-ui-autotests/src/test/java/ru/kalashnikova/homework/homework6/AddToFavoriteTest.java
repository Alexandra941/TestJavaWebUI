package ru.kalashnikova.homework.homework6;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;
import ru.kalashnikova.homework.homework6.pages.ProductPage;

@DisplayName("Страница \"Избранное\"")
public class AddToFavoriteTest extends BaseTest {

    @Test
    @DisplayName("Успешное добавление товара в избранное")
    @Epic("Автоматизация тестирования Web UI на Java")
    @Story("Урок 7. Allure, протоколирование")
    public void addToFavoriteTest() {
        ProductPage productPage = new MainPage(webDriver)
                .getHeader()
                .clickToLogin()
                .login()
                .goToFavorite()
                .checkFavoriteIsEmpty()
                .goToProductsPage()
                .openProductPage();

        String productName = productPage.getProductName();
        productPage.addProductToFavorite();

        new MainPage(webDriver)
                .getHeader()
                .goToFavorite()
                .checkProductInFavorite(productName)
                .clearFavorite()
                .checkFavoriteIsEmpty();
    }
}
