package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverBased {
    public String driverName = "";
    public WebDriver getDriver() { return WebDriverFactory.getDriver(driverName); }
    public JavascriptExecutor js() { return (JavascriptExecutor)getDriver(); }
}
