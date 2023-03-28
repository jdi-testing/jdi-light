package nativeapp.ios.settings;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(app = "com.apple.Preferences")
public class SettingsApp {

    public static SettingsListPage settingsListPage;
    public static AccessibilityPage accessibilityPage;
    public static DisplayAndTextSizePage displayAndTextSizePage;
    public static LargerTextPage largerTextPage;

}
