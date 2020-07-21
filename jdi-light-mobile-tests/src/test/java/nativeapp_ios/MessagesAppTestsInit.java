package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.ios.messages.MessagesApp;
import nativeapp.ios.messages.WhatsNewPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class MessagesAppTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(MessagesApp.class);
        logger.toLog("Run Messages App Tests");
    }

    @BeforeMethod(alwaysRun = true)
    public void continueThroughWelcomePage() {
        if (WhatsNewPage.continueButton.isDisplayed()) {
            WhatsNewPage.continueButton.tap();
        }
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
