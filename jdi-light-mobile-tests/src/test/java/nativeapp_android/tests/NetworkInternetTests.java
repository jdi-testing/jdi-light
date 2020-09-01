package nativeapp_android.tests;

import nativeapp_android.NetworkAndInternetInit;
import org.testng.annotations.Test;

import static nativeapp.android.NetworkAndInternet.*;
import static org.testng.Assert.assertTrue;

public class NetworkInternetTests extends NetworkAndInternetInit {
    @Test
    public void toggleButtonAirplaneModeTest(){
        networkAndInternetButton.click();
        airplaneMode.toggleBtnIsDisplayed();
        airplaneMode.setToOn();
        airplaneMode.isOn();
        airplaneMode.setToOff();
        airplaneMode.is().off();

    }

    @Test
    public void toggleButtonWiFiTest(){
        networkAndInternetButton.click();
        wiFi.toggleBtnIsDisplayed();
        wiFi.setToOn();
        wiFi.isOn();
        wiFi.setToOff();
        wiFi.is().off();
    }
}
