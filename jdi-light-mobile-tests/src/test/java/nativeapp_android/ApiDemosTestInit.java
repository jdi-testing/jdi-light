package nativeapp_android;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.android.apidemos.ApiDemosApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_ANDROID;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ApiDemosTestInit {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
//        final String FILE_NAME = "src/main/resources/ApiDemos-debug.apk";
        CAPABILITIES_FOR_ANDROID.put("build", "Android Native App tests build 3");
        CAPABILITIES_FOR_ANDROID.put("name", this.getClass().getSimpleName());
        initMobile(ApiDemosApp.class);
        logger.toLog("Run ApiDemos App Tests");
//        File file = new File(FILE_NAME);
//        String path = file.getAbsolutePath();
//        AppManager.installApp(path);
        AppManager.launchApp();
    }
    @AfterMethod(alwaysRun = true)
    public void resetApp() {
        AppManager.resetApp();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quitDriverNativeApp();
    }
}
