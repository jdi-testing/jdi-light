package nativeapp_android;

import com.epam.jdi.light.driver.WebDriverFactory;
import nativeapp.android.apidemos.ApiDemosApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ApiDemosEspressoTestInit {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(ApiDemosApp.class);
        logger.toLog("Run ApiDemos App Tests");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quitDriverNativeApp();
    }
}
