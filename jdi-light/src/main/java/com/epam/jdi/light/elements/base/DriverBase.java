package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverBase {
    public static final String DEFAULT_DRIVER = "chrome";
    public String driverName = DEFAULT_DRIVER;
    public WebDriver driver() { return WebDriverFactory.getDriver(driverName); }
    public JavascriptExecutor js() { return (JavascriptExecutor) driver(); }

    public <T> T asEntity(Class<T> entityClass) {
        return UIUtils.asEntity(this, entityClass);
    }
}
