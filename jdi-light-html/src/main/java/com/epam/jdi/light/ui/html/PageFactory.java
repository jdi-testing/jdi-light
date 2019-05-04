package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.init.PageFactory.PRE_INIT;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 * <p>
 * Selenium PageFactory
 */

public class PageFactory {

    public static void initSite(Class<?> site, String driverName) {
        PRE_INIT = HtmlSettings::init;
        com.epam.jdi.light.elements.init.PageFactory.initSite(site, driverName);
    }
    public static void initSite(Class<?> site) {
        PRE_INIT = HtmlSettings::init;
        com.epam.jdi.light.elements.init.PageFactory.initSite(site);
    }
    public static void initElements(Class<?> site, JFunc<WebDriver> driver) {
        String driverName = WebDriverFactory.useDriver(driver);
        initSite(site, driverName);
    }
    public static void initElements(Class<?> site) {
        initSite(site);
    }
    public static void initElements(JFunc<WebDriver> driver, Object... pages) { }
    public static void initElements(Class<?>... pages) {
        for (Class<?> page : pages) {
            initElements((WebDriver) null, page);
        }
    }
    public static void initElements(Object... pages) {
        PRE_INIT = HtmlSettings::init;
        com.epam.jdi.light.elements.init.PageFactory.initElements(pages);
    }

    // Selenium PageFactory
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        PRE_INIT = HtmlSettings::init;
        return com.epam.jdi.light.elements.init.PageFactory.initElements(driver, pageClassToProxy);
    }
    public static void initElements(WebDriver driver, Object page) {
        initElements(page);
    }
    public static void initElements(ElementLocatorFactory factory, Object page) {
        initElements(page);
    }
    public static void initElements(FieldDecorator decorator, Object page) {
        initElements(page);
    }
}