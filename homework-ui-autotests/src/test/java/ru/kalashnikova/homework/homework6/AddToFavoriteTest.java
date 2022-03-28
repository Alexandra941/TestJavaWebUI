package ru.kalashnikova.homework.homework6;

import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;
import ru.kalashnikova.homework.homework6.pages.ProductPage;

public class AddToFavoriteTest extends BaseTest {
    @Test
    public void addToFavoriteTest() throws InterruptedException {
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
