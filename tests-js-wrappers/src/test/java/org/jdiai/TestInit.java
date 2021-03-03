package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static org.jdiai.Pages.*;
import static org.jdiai.jsbuilder.JSBuilder.LOG_QUERY;
import static org.jdiai.jswraper.JSWrapper.DRIVER;

public interface TestInit {
    default String[] withParent(String locator) {
        return new String[] {".uui-header", ".profile-photo", locator };
    }
    default String[] inForm(String locator) {
        return new String[] {".uui-header", "form", locator };
    }

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        initDriver();
        openSite();
        LOG_QUERY = true;
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killDrivers();
    }

    default void initDriver() {
        DRIVER = new Safe<>(() -> {
            WebDriver driver = chromeDriver();
            driver.get(HOME_PAGE);
            driver.manage().window().maximize();
            return driver;
        });
    }
    default void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }
}
