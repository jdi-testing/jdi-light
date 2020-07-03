package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.appium.java_client.AppiumDriver;
import nativeapp.ios.messages.MessagesApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class MessagesAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(MessagesApp.class);
        AppiumDriver driver = (AppiumDriver) getDriver();
        driver.launchApp();
        logger.toLog("Run Messages App Tests");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
