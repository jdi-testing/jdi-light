package io.github.epam;

import io.github.com.StaticSite;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.com.StaticSite.*;

public class StaticTestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
