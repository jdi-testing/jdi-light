package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.appPage;
import static nativeapp.android.apidemos.app.AppPage.fragmentPage;
import static nativeapp.android.apidemos.app.ContextMenuPage.longPressButton;
import static nativeapp.android.apidemos.app.ContextMenuPage.menuView;
import static nativeapp.android.apidemos.app.FragmentPage.contextMenuPage;

public class ContextMenuTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        appPage.click();
        fragmentPage.click();
        contextMenuPage.tap();
    }

    @Test
    public void contextMenuTests() {
        longPressButton.shouldBe().visible();
        longPressButton.longPress();
        menuView.shouldBe().visible();
    }
}