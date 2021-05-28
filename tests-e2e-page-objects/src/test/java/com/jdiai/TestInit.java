package com.jdiai;

import com.jdiai.site.HomePage;
import com.jdiai.site.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.jdiai.jsbuilder.QueryLogger.ALL;
import static com.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static com.jdiai.jswraper.DriverManager.CHROME_OPTIONS;
import static com.jdiai.jswraper.DriverManager.killDrivers;
import static com.jdiai.page.objects.PageFactory.initElements;
import static com.jdiai.page.objects.PageFactory.initSite;
import static com.jdiai.tools.TestIDLocators.ID_LOCATOR;
import static com.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public interface TestInit {
    default HomePage homePage() { return initElements(HomePage.class); }

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        SMART_LOCATOR = ID_LOCATOR;
        // CHROME_OPTIONS = cap -> cap.addArguments("--headless");
        LOG_QUERY = ALL;
        initSite(JDISite.class);
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
