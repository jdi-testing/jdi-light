package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.elements.interfaces.complex.IsChecklist;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.Checklist;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class PageFactory {

    private static void init() {
        INTERFACES.update(new Object[][]{
            { IsChecklist.class, Checklist.class },
            { IsCombobox.class, DataListOptions.class }
        });
    }
    public static void initSite(Class<?> site) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initSite(site);
    }
    public static void initSite(Class<?> site, String driverName) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initSite(site, driverName);
    }

    // region Selenium PageFactory
    public static void initElements(JFunc<WebDriver> driver, Object... pages) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(driver, pages);
    }
    public static void initElements(Class<?> site) {
        initSite(site);
    }
    public static void initElements(Object page) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(page);
    }
    public static void initElements(Object... pages) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(pages);
    }
    public static void initElements(Class<?>... pages) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(pages);
    }
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        init();
        return com.epam.jdi.light.elements.init.PageFactory.initElements(driver, pageClassToProxy);
    }
    public static void initElements(WebDriver driver, Object page) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(driver, page);
    }
    public static void initElements(ElementLocatorFactory factory, Object page) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(factory, page);
    }
    public static void initElements(FieldDecorator decorator, Object page) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(decorator, page);
    }
    // endregion
}