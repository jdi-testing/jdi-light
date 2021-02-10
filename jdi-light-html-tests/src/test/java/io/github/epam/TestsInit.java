package io.github.epam;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pseudo.site.PseudoSite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.reload;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        killAllSeleniumDrivers();
        initSite(StaticSite.class);
        initSite(PseudoSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killAllSeleniumDrivers();
    }

    default boolean isFireFox() {
        String ffName = "firefox";
        logger.info("Browser %s is used. isFirefox=%s", DRIVER.name, ffName.equalsIgnoreCase(DRIVER.name));
        return ffName.equalsIgnoreCase(DRIVER.name);
    }

    default void skipForFirefox() {
        if (isFireFox()) {
            throw new SkipException("Test is skipped for Firefox browser");
        }
    }

    @AfterMethod
    default void refreshPageOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            reload();
        }
    }

    default void skip() {
        throw new SkipException("Test is skipped for Firefox browser");
    }
}
