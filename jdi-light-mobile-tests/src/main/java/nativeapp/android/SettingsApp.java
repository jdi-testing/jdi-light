package nativeapp.android;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(appPackage = "com.android.settings", appActivity = "com.android.settings.Settings")
public class SettingsApp {
    public static NetworkAndInternet networkAndInternet;
}
