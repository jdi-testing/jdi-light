package io.github.epam;

import io.github.com.StaticSite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class StaticTestsInit extends TestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(StaticSite.class);
        logger.toLog("Run Tests");
    }
}
