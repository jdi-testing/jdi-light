package io.github.epam;

import io.github.epam.testng.TestNGListener;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.epam.EpamGithubSite.*;

public class TestsInit extends TestNGListener {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(EpamGithubSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }
    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
