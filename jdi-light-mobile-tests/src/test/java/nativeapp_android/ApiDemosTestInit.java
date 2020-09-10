package nativeapp_android;

import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.android.SettingsApp;
import nativeapp.android.apiDemos.ApiDemosApp;

import java.io.File;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ApiDemosTestInit {
    public void setUp() {
        final String FILE_NAME = "src/main/resources/ApiDemos-debug.apk";
        initMobile(ApiDemosApp.class);
        logger.toLog("Run ApiDemos App Tests");
        File file = new File(FILE_NAME);
        String path = file.getAbsolutePath();
        AppManager.installApp(path);
        AppManager.launchApp();
    }
}
