package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.ios.calendar.CalendarApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class CalendarAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(CalendarApp.class);
        logger.toLog("Run Calendars App Tests");
    }

    @AfterMethod(alwaysRun = true)
    public void resetApp() {
        AppManager.resetApp();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
