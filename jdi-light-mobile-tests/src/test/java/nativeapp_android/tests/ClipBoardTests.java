package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import nativeapp.android.SettingsApp;
import nativeapp_android.SettingsAppTestsInit;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClipBoardTests extends SettingsAppTestsInit {

    String text = "Modem mode";

    @Test
    public void clipBoardTest() {
        MobileDevice.setClipBoardText(text);
        String getText = MobileDevice.getClipBoardText();
        System.out.println(getText);
        assertThat(getText.contains(text));
    }

    @Test
    public void clipBoardSetOnDeviceTest() throws NullPointerException, InterruptedException {
        MobileDevice.setClipBoardText(text);
        SettingsApp.search.click();
        TouchAction touchAction = new TouchAction((PerformsTouchActions) WebDriverFactory
                .getDriver());
        Thread.sleep(4000);
        touchAction.press(PointOption.point(899, 1472)).release().perform();
        touchAction.press(PointOption.point(291,1702)).release().perform();
        assertThat(SettingsApp.searchText.getText().equals(text));
    }
}
