package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuToggleSwitch;
import static nativeapp.ios.epamiostestapp.ToggleSwitchPage.switchButton;

public class SwitchTest extends IosApplicationInit {

    @Test
    public void switchTest() {
        menuToggleSwitch.tap();

        switchButton.setToOn();
        switchButton.is().on();

        switchButton.setToOff();
        switchButton.is().off();

    }
}
