package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import io.appium.java_client.ios.IOSDriver;
import nativeapp.ios.reminders.RemindersApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class RemindersAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(RemindersApp.class);
        AppManager.launchApp("com.apple.reminders");
        logger.toLog("Run Reminders App Tests");
    }

    @BeforeMethod(alwaysRun = true)
    public void continueThroughWelcomePage() {
        if (RemindersApp.continueButton.isDisplayed())
            RemindersApp.continueButton.click();
    }

    @AfterMethod(alwaysRun = true)
    public void resetApp() {
        AppManager.resetApp("com.apple.reminders");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
