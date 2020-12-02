package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.network.Toggle;
import nativeapp_android.ApiDemosTestInit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToggleAirplaneModeTests extends ApiDemosTestInit {

    @Test
    public void toggleAirplaneModeTests(){
        boolean isAirplaneModeEnabled = Toggle.getConnection().isAirplaneModeEnabled();

        Toggle.toggleAirplaneMode();
        Assert.assertNotEquals(
                isAirplaneModeEnabled,
                Toggle.getConnection().isAirplaneModeEnabled(),
                "Connection state not change after toggle airplane mode,\n"
        );
    }
}