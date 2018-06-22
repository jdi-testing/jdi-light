package org.mytests.tests.example;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.mytests.uiobjects.example.site.JDIExampleSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.common.ActionProcessor.ERROR_THROWN;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(STEP);
        initElements(JDIExampleSite.class);
        logger.info("Run Tests");
    }

    @BeforeMethod
    public void before() {
        ERROR_THROWN = false;
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverFactory.close();
    }
}
