package nativeapp_android.tests.SystemAndroid11Tests;

import com.epam.jdi.light.mobile.elements.common.network.Toggle;
import nativeapp_android.ApiDemosTestInit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToggleDataTests extends ApiDemosTestInit {

    @Test
    public void toggleDataTests(){
        boolean isDataEnabled = Toggle.getConnection().isDataEnabled();

        Toggle.toggleData();
        Assert.assertNotEquals(
                isDataEnabled,
                Toggle.getConnection().isDataEnabled(),
                "Connection state not change after toggle data,\n"
        );
    }
}
