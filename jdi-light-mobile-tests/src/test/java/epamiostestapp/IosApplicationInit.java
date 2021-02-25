package epamiostestapp;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.ios.epamiostestapp.IOSAppInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class IosApplicationInit {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(IOSAppInit.class);
        logger.toLog("Run tests for app: EpamIOSTestApp");
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
