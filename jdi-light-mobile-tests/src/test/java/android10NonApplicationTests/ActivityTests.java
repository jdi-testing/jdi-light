package android10NonApplicationTests;

import com.epam.jdi.light.mobile.elements.common.MobileDeviceActivity;
import nativeapp_android.ActivityTestsInit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActivityTests extends ActivityTestsInit {

    @DataProvider(name = "forStartActivityTest")
    public Object[][] providerForStartActivity() {
        return new Object[][]{
            {"com.android.dialer",                  ".main.impl.MainActivity"},
                /*
                Error at this activities
            {"com.google.android.apps.messaging",   ".ui.ConversationListActivity"},
            {"com.google.android.deskclock",        "com.android.deskclock.DeskClock"},

                 */
            {"com.android.camera2",                 "com.android.camera.CameraLauncher"},
            {"com.android.settings",                ".Settings"}
        };
    }

    @Test(dependsOnMethods = {"getPackageTest", "getActivityTest"},
          dataProvider = "forStartActivityTest")
    public void startActivityTest(String expPack, String expActivity) {
        MobileDeviceActivity.startActivity(expPack, expActivity);
        String currentPack = MobileDeviceActivity.currentPackage();
        String currentActivity = MobileDeviceActivity.currentActivity();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(currentPack, expPack);
        softAssert.assertEquals(currentActivity, expActivity);
        softAssert.assertAll();
    }

    @Test
    public void getActivityTest() {
        String actualResult = MobileDeviceActivity.currentActivity();
        String expectedResult = ".ApiDemos";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void getPackageTest() {
        String actualResult = MobileDeviceActivity.currentPackage();
        String expectedResult = "io.appium.android.apis";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
