package org.jdiai.jselement;

import org.jdiai.jsdriver.JSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class JSBase {
    protected JSDriver driver;

    public JSBase(WebDriver driver, List<By> locators) {
        this.driver = new JSDriver(driver, locators);
    }
    public JSBase(WebDriver driver, By... locators) {
        this.driver = new JSDriver(driver, locators);
    }

    public void doAction(String text) {
        driver.attribute(text).getOne();
    }
    public String getStyle(String style) {
        return driver.getStyle(style);
    }
}
