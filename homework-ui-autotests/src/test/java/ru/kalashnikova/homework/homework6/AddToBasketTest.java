package ru.kalashnikova.homework.homework6;

import org.junit.jupiter.api.Test;
import ru.kalashnikova.homework.homework6.pages.MainPage;
import ru.kalashnikova.homework.homework6.pages.ProductPage;

public class AddToBasketTest extends BaseTest {
    @Test
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
