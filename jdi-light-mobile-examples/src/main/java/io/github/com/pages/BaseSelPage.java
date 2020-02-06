package io.github.com.pages;

import com.epam.jdi.mobile.elements.interfaces.composite.PageObject;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

public class BaseSelPage implements PageObject {
    @Css("h3[name='test-page-object']") public WebElement testField;
}
