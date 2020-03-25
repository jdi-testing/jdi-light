package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static com.epam.jdi.light.elements.init.InitActions.JDI_ANNOTATIONS;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.aRule;
import static com.epam.jdi.light.mobile.elements.pageobjects.annotations.WebAnnotationsUtil.mobileFindByToBy;
import static com.epam.jdi.light.mobile.settings.MobileSettings.*;
import static com.epam.jdi.light.settings.WebSettings.TEST_GROUP;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.pairs.Pair.$;

/**
 * Created by Roman Iovlev on 20.03.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class PageFactory {
    public static void initMobile(Class<?> site) {
        JDI_ANNOTATIONS.add($("MobileFindByUI", aRule(MobileFindBy.class, (e, a, f)-> {
            MobileFindBy[] jmfindbys = f.getAnnotationsByType(MobileFindBy.class);
            if (jmfindbys.length > 0 && any(jmfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
                e.setLocator(mobileFindByToBy(first(jmfindbys, j -> j.group().equals(TEST_GROUP))));
        })));
        init();
        com.epam.jdi.light.elements.init.PageFactory.initSite(site);
    }
    public static void initMobile(Class<?> site, String driverName) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initSite(site, driverName);
    }

    // region Selenium PageFactory
    public static void initElements(JFunc<WebDriver> driver, Object... pages) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(driver, pages);
    }
    public static void initElements(Class<?> site) {
        init();
        com.epam.jdi.light.elements.init.PageFactory.initElements(site);
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