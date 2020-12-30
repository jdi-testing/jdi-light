package nativeapp_android.tests.SystemAndroid11Tests;

import com.epam.jdi.light.mobile.elements.common.network.Toggle;
import nativeapp_android.ApiDemosTestInit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToggleWiFiTests extends ApiDemosTestInit {

    @Test
    public void toggleWiFiTests(){
        boolean isWifiEnabled = Toggle.getConnection().isWiFiEnabled();

        Toggle.toggleWifi();
        Assert.assertNotEquals(
                isWifiEnabled,
                Toggle.getConnection().isWiFiEnabled(),
                "Connection state not change after toggle wifi,\n"
        );
    }
}
