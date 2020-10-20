package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import nativeapp.android.ClockApp;
import nativeapp.android.apiDemos.ApiDemosApp;
import nativeapp.android.apiDemos.TextFieldsPage;
import nativeapp.android.apiDemos.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.security.mscapi.CKeyPairGenerator;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apiDemos.IndexPage.viewsPage;
import static org.assertj.core.api.Assertions.assertThat;

public class MobileKeyboardTests extends ApiDemosTestInit {
    @BeforeMethod(alwaysRun = true)
    public void initSteps() {
        viewsPage.click();
        while (true){
            try {
                ViewsPage.textFieldsPage.click();
                return;
            } catch (RuntimeException e){
                MobileScreen.scrollDown(1000);
            }
        }
    }

    @Test
    public void pressKeyTest() {
        TextFieldsPage.displayedInputTextField.tap();
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.APOSTROPHE));
        assertThat(TextFieldsPage.displayedInputTextField.getText()).isEqualTo("'");
    }

    @Test
    public void longPressKeyTest() throws InterruptedException {
        TextFieldsPage.displayedInputTextField.tap();
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.APOSTROPHE));
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.APOSTROPHE));
        MobileKeyboard.longPressKey(new KeyEvent(AndroidKey.DEL));
        assertThat(TextFieldsPage.displayedInputTextField.getText()).
                isEqualTo("");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
