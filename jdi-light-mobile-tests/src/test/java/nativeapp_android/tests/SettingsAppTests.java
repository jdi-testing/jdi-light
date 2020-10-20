package nativeapp_android.tests;

import nativeapp_android.SettingsAppTestsInit;
import org.testng.annotations.Test;

import static nativeapp.android.NetworkAndInternetPage.*;


public class SettingsAppTests extends SettingsAppTestsInit {

    @Test
    public void switchAirplaneModeTest(){
        networkAndInternetButton.click();
        airplaneModeSwitch.setToOn();
        airplaneModeSwitch.is().on();
        airplaneModeSwitch.setToOff();
        airplaneModeSwitch.is().off();

    }

    @Test
    public void switchWiFiConnectionTest(){
        networkAndInternetButton.click();
        wiFiSwitch.setToOn();
        wiFiSwitch.is().on();
        wiFiSwitch.setToOff();
        wiFiSwitch.is().off();
    }
}
