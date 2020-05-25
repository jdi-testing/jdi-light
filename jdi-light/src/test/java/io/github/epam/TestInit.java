package io.github.epam;

import io.github.epam.testng.TestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public class TestInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        logger.toLog("End Tests");
    }
}
