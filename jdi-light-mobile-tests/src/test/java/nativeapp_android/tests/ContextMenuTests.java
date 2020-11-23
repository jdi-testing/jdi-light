package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.apiDemos.AppPage.fragmentPage;
import static nativeapp.android.apiDemos.ContextMenuPage.longPressButton;
import static nativeapp.android.apiDemos.ContextMenuPage.menuView;
import static nativeapp.android.apiDemos.FragmentPage.contextMenuPage;
import static nativeapp.android.apiDemos.IndexPage.appPage;

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