package nativeapp_ios.tests;

import nativeapp.ios.settings.AccessibilityPage;
import nativeapp.ios.settings.DisplayAndTextSizePage;
import nativeapp.ios.settings.LargerTextPage;
import nativeapp.ios.settings.SettingsListPage;
import nativeapp_ios.SettingsAppTestInit;
import org.testng.annotations.Test;

public class SettingsAppTests extends SettingsAppTestInit {
    @Test
    public void sliderTest() {
        SettingsListPage.accessibilityMenuItem.tap();
        AccessibilityPage.displayAndTextSizeMenuItem.tap();
        DisplayAndTextSizePage.largerTextMenuItem.tap();

        LargerTextPage.largerTextSlider.setSliderValue("0.5");
        LargerTextPage.largerTextSlider.is().text("50%");

        LargerTextPage.largerTextSlider.setMaximumValue();
        LargerTextPage.largerTextSlider.is().text("100%");

        LargerTextPage.largerTextSlider.setMinimumValue();
        LargerTextPage.largerTextSlider.is().text("0%");
    }

    @Test
    public void pullDownMenuTest() {
        SettingsListPage.accessibilityMenuItem.tap();
        AccessibilityPage.displayAndTextSizeMenuItem.tap();

        DisplayAndTextSizePage.backButton.longPress();
        DisplayAndTextSizePage.settingsPullDownMenu.tapButton("Settings");

        SettingsListPage.settingsNavigationBar.is().displayed();
    }
}
