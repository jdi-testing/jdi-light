package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.android.apidemos.pages.FlutterGalleryWelcomePage;
import nativeapp.android.apidemos.pages.SettingsPage;
import nativeapp.android.apidemos.views.*;

@JApp(appPackage = "io.flutter.demo.gallery", appActivity = ".MainActivity")
public class ApiDemosApp {

    public static FlutterGalleryWelcomePage flutterPage;
    public static MaterialUIView materialUIView;
    public static SettingsPage settingsPage;
}
