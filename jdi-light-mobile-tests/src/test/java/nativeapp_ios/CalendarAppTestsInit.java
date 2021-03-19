package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.ios.calendar.CalendarApp;
import nativeapp.ios.calendar.WelcomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class CalendarAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(CalendarApp.class);
        logger.toLog("Run Calendars App Tests");
    }

    @BeforeMethod(alwaysRun = true)
    public void continueThroughWelcomePage() {
        if(WelcomePage.continueButton.isDisplayed())
            WelcomePage.continueButton.tap();
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
