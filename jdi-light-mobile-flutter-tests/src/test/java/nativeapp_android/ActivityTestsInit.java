package nativeapp_android;

import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.android.apidemos.ApiDemosApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import static com.epam.jdi.light.actions.ActionHelper.BEFORE_JDI_ACTION;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ActivityTestsInit {

    @BeforeSuite
    public void changeBefore() {
        BEFORE_JDI_ACTION = jInfo -> {
            try {
                ActionHelper.beforeJdiAction(jInfo);
            }
            catch (Exception ignore) {
                logger.error("Exception in JDI!!!!", ignore);
            }
        };
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        final String FILE_NAME = "src/test/resources/flutter_gallery_Android.apk";
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
