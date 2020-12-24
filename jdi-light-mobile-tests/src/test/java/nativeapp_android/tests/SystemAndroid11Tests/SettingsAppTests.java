package nativeapp_android.tests.SystemAndroid11Tests;

import nativeapp_android.SettingsAppTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.NetworkAndInternetPage.airplaneModeForAndroid11;
import static nativeapp.android.NetworkAndInternetPage.networkAndInternetButton;
import static nativeapp.android.NetworkAndInternetPage.wiFiSwitch;

public class SettingsAppTests extends SettingsAppTestsInit {

    @BeforeMethod
    public void init() {
        networkAndInternetButton.click();
    }

    @Test
    public void switchAirplaneModeTest() {

        airplaneModeForAndroid11.setToOn();
        airplaneModeForAndroid11.is().on();
        airplaneModeForAndroid11.setToOff();
        airplaneModeForAndroid11.is().off();

    }

    @Test
    public void switchWiFiConnectionTest(){
        wiFiSwitch.setToOn();
        wiFiSwitch.is().on();
        wiFiSwitch.setToOff();
        wiFiSwitch.is().off();
    }
}
