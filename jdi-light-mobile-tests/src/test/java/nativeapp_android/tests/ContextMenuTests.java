package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.AppPage.fragmentPage;
import static nativeapp.android.apidemos.ContextMenuPage.longPressButton;
import static nativeapp.android.apidemos.ContextMenuPage.menuView;
import static nativeapp.android.apidemos.FragmentPage.contextMenuPage;
import static nativeapp.android.apidemos.IndexPage.appPage;

public class ContextMenuTests extends ApiDemosTestInit {

    @Test
    public void contextMenuTests() {
        appPage.click();
        fragmentPage.click();
        contextMenuPage.tap();
        longPressButton.shouldBe().visible();

        longPressButton.longPress();
        menuView.shouldBe().visible();
    }
}