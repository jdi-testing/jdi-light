package android10NonApplicationTests;

import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import nativeapp.android.SettingsApp;
import nativeapp_android.SettingsAppTestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class ClipBoardTests extends SettingsAppTestsInit {

    private String text = "Modem mode";

    @Test
    public void clipBoardTest() {
        MobileDevice.setClipBoardText(text);
        String getText = MobileDevice.getClipBoardText();
        assertThat(getText.contains(text));
    }
}
