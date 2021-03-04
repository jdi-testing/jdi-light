package org.jdiai;

import com.epam.jdi.tools.Safe;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.Runtime.getRuntime;
import static org.jdiai.Pages.HOME_PAGE;
import static org.jdiai.Pages.chromeDriver;
import static org.jdiai.jsbuilder.JSBuilder.LOG_QUERY;
import static org.jdiai.tools.JSTalk.DRIVER;
import static org.jdiai.tools.JSTalk.openSite;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        killDrivers();
        initDriver();
        openSite("https://jdi-testing.github.io/jdi-light");
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
