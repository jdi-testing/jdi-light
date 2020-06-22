package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import nativeapp.ios.messages.MessagesApp;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class MessagesAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(MessagesApp.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
//        AppiumDriver driver = (AppiumDriver) getDriver();
//        driver.closeApp();
        WebDriverFactory.quit();
    }
}
