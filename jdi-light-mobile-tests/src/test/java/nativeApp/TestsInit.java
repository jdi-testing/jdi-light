package nativeapp;

import nativeapp.contacts.StaticNativeApp;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;

public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        initElements(StaticNativeApp.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killAllSeleniumDrivers();
    }
}
