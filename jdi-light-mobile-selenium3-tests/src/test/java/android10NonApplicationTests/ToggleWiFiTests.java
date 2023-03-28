package android10NonApplicationTests;

import com.epam.jdi.light.mobile.elements.common.network.Toggle;
import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static nativeapp.android.apidemos.NotifyPage.wifiIcon;

public class ToggleWiFiTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        AndroidScreen.openNotificationPanel();
    }

    @Test
    public void toggleWiFiTests(){
        wifiIcon.click();
        Toggle.getConnection().isWiFiEnabled();
    }

    @AfterMethod
    public void tearDown() {
        TouchAction<?> touchAction = new TouchAction<>((PerformsTouchActions) getDriver());
        touchAction.press(PointOption.point(121, 333)).release().perform();
        AndroidScreen.closeNotificationPanel();
    }
}
