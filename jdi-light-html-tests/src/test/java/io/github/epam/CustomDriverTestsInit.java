package io.github.epam;

import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverFactory.useDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverInfos.FF_INFO;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static io.github.com.StaticSite.homePage;

public class CustomDriverTestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        useDriver(() -> FF_INFO.getDriver() );
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

}
