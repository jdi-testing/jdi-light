package org.jdiai.jselement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class JSElement extends JSBase {
    public JSElement(WebDriver driver, List<By> locators) {
        super(driver, locators);
    }
    public JSElement(WebDriver driver, By... locators) {
        super(driver, locators);
    }

    public String getAttribute(String text) {
        return driver.attribute(text).getOne().asString();
    }
    public List<String> getAttributes(String text) {
        return driver.attribute(text).getList().asString();
    }
}
