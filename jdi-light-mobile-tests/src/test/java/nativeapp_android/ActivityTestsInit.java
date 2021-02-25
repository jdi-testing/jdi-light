package nativeapp_android;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.android.apidemos.ApiDemosApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ActivityTestsInit {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        final String FILE_NAME = "src/main/resources/ApiDemos-debug.apk";
        initMobile(ApiDemosApp.class);
        logger.toLog("Run Activity Tests");
        File file = new File(FILE_NAME);
        String path = file.getAbsolutePath();
        AppManager.installApp(path);
        AppManager.launchApp();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.toLog("tearDown Activity Tests");
        AppManager.closeApp();
        AppManager.removeApp("io.appium.android.apis");
        WebDriverFactory.quit();
    }
}
