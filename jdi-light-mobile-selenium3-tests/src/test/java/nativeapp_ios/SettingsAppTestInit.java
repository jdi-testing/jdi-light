package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import nativeapp.ios.settings.SettingsApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class SettingsAppTestInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(SettingsApp.class);
        logger.toLog("Run Settings App Tests");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
