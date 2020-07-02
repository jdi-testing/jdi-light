package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.appium.java_client.AppiumDriver;
import nativeapp.ios.calendar.CalendarApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class CalendarAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(CalendarApp.class);
        logger.toLog("Run Calendars App Tests");
    }

    @BeforeMethod
    public void openApp() {
        AppiumDriver driver = (AppiumDriver) getDriver();
        driver.launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        AppiumDriver driver = (AppiumDriver) getDriver();
        driver.closeApp();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
