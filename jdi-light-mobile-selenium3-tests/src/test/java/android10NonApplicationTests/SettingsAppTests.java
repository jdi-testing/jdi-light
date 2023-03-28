package android10NonApplicationTests;

import nativeapp_android.SettingsAppTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.NetworkAndInternetPage.*;


public class SettingsAppTests extends SettingsAppTestsInit {

    @BeforeMethod
    public void init() {
        networkAndInternetButton.click();
    }

    @Test
    public void switchAirplaneModeTest(){
        airplaneModeSwitch.setToOn();
        airplaneModeSwitch.is().on();
        airplaneModeSwitch.setToOff();
        airplaneModeSwitch.is().off();

    }

    @Test
    public void switchWiFiConnectionTest(){
        wiFiSwitch.setToOn();
        wiFiSwitch.is().on();
        wiFiSwitch.setToOff();
        wiFiSwitch.is().off();
    }
}
