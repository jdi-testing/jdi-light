package io.github.epam;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.settings.WebSettings;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.splitHyphen;

@SuppressWarnings("PMD.ClassNamingConventions")
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        openSite(StaticSite.class);
        logger.toLog("Run Tests");
        SMART_SEARCH = el -> {
            String locatorName = splitHyphen(el.getName());
            UIElement ui = $("[qa-item='" + locatorName + "']").setName(el.getName());
            if (ui.isDisplayed())
                return ui.getAll();
            throw exception("Element '%s' has no locator and Smart Search failed. Please add locator to element or be sure that element can be found using Smart Search", el.getName());
        };
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
