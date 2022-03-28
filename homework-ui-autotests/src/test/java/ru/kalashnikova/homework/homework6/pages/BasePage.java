package ru.kalashnikova.homework.homework6.pages;

import org.openqa.selenium.WebDriver;
import ru.kalashnikova.homework.homework6.pages.blocks.MainHeader;

public class BasePage  extends BaseView {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader getHeader() {
        return new MainHeader(webDriver);
    }
}
