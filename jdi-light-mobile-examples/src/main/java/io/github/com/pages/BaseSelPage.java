package io.github.com.pages;

import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

public class BaseSelPage implements PageObject {
    @Css("h3[name='test-page-object']") public WebElement testField;
}
