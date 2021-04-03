package org.jdiai;

import org.jdiai.site.HomePage;
import org.jdiai.site.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static org.jdiai.jswraper.DriverManager.CHROME_OPTIONS;
import static org.jdiai.jswraper.DriverManager.killDrivers;
import static org.jdiai.page.objects.PageFactory.initElements;
import static org.jdiai.page.objects.PageFactory.openSite;
import static org.jdiai.tools.TestIDLocators.ID_LOCATOR;
import static org.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public interface TestInit {
    default HomePage homePage() { return initElements(HomePage.class); }

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        SMART_LOCATOR = ID_LOCATOR;
        CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        LOG_QUERY = ALL;
        openSite(JDISite.class);
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
