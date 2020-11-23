package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import nativeapp.android.apiDemos.TextFieldsPage;
import nativeapp.android.apiDemos.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apiDemos.IndexPage.viewsPage;
import static org.assertj.core.api.Assertions.assertThat;

public class MobileKeyboardTests extends ApiDemosTestInit {

    @BeforeClass
    public void beforeClass() {
        logger.toLog("Run MobileKeyboardTests");
    }

    @BeforeMethod(alwaysRun = true)
    public void initSteps() {
        viewsPage.click();
        while (true) {
            try {
                ViewsPage.textFieldsPage.click();
                return;
            } catch (RuntimeException e) {
                MobileScreen.scrollDown(1000);
            }
        }
    }

    @Test
    public void pressKeyTest() {
        TextFieldsPage.visibleTextField.tap();
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.APOSTROPHE));
        assertThat(TextFieldsPage.visibleTextField.getText()).isEqualTo("'");
    }

    @Test
    public void longPressKeyTest() {
        TextFieldsPage.visibleTextField.tap();
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.APOSTROPHE));
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.APOSTROPHE));
        MobileKeyboard.longPressKey(new KeyEvent(AndroidKey.DEL));
        assertThat(TextFieldsPage.visibleTextField.getText())
                .isEqualTo("");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
