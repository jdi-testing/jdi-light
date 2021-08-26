package com.jdiai;

import com.jdiai.site.HomeBasePage;
import com.jdiai.site.HomePage;
import com.jdiai.site.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.jdiai.jsbuilder.QueryLogger.ALL;
import static com.jdiai.jswraper.driver.DriverManager.killDrivers;
import static com.jdiai.jswraper.driver.JDIDriver.DRIVER_OPTIONS;
import static com.jdiai.page.objects.PageFactory.initElements;
import static com.jdiai.page.objects.PageFactory.initSite;
import static com.jdiai.tools.TestIDLocators.ID_LOCATOR;
import static com.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public interface TestInit {
    default HomePage homePage() {
        return initElements(HomePage.class);
    }

    default HomeBasePage homeBasePage() {
        return initElements(HomeBasePage.class);
    }

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        SMART_LOCATOR = ID_LOCATOR;
        DRIVER_OPTIONS.chrome = cap -> cap.addArguments("--headless");
        JDI.logJSRequests(ALL);
        initSite(JDISite.class);
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }
}
