package io.github.com.pages;

import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

public class BasePage extends WebPage {
    @Css("h3[name='test']") public WebElement testField;
}
