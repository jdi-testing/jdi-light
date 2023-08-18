package io.github.epam;

import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.reload;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public class TestsInit {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }

    @AfterMethod
    public void refreshPageOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            reload();
        }
    }
}
