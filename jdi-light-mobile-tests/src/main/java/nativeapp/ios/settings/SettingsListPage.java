package nativeapp.ios.settings;

import com.epam.jdi.light.mobile.elements.common.app.ios.MenuItem;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SettingsListPage {

    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"Accessibility\"]")
    public static MenuItem accessibilityMenuItem;

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Settings\"]")
    public static NavigationBar settingsNavigationBar;

}
