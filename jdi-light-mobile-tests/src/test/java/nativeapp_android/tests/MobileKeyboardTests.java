package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp.android.apidemos.views.TextFieldsPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static nativeapp.android.apidemos.IndexPage.viewsPage;

public class MobileKeyboardTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        viewsPage.click();
        MobileScreen.scrollToElementInList(ViewsPage.textFieldsPage);
        ViewsPage.textFieldsPage.click();
    }

    @Test
    public void pressKeyTest() {
        TextFieldsPage.visibleTextField.tap();
        MobileKeyboard.pressKey(AndroidKey.APOSTROPHE);
        jdiAssert(TextFieldsPage.visibleTextField.getText(), Matchers.is("'"));
    }

    @Test
    public void longPressKeyTest() {
        TextFieldsPage.visibleTextField.tap();
        MobileKeyboard.pressKey(AndroidKey.APOSTROPHE);
        MobileKeyboard.pressKey(AndroidKey.APOSTROPHE);
        MobileKeyboard.longPressKey(AndroidKey.DEL);
        jdiAssert(TextFieldsPage.visibleTextField.getText(), Matchers.is(""));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
