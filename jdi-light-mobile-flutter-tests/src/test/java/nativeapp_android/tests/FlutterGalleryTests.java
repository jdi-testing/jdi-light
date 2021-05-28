package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.ApiDemosApp.flutterPage;
import static nativeapp.android.apidemos.ApiDemosApp.materialUIView;
import static nativeapp.android.apidemos.ApiDemosApp.settingsPage;
import static nativeapp.android.apidemos.pages.FlutterGalleryWelcomePage.back;
import static nativeapp.android.apidemos.pages.FlutterGalleryWelcomePage.material;
import static nativeapp.android.apidemos.views.MaterialUIView.appBar;
import static nativeapp.android.apidemos.views.MaterialUIView.textFields;

public class FlutterGalleryTests extends ApiDemosTestInit {
    @Test
    public void SettingsTest() {
        flutterPage.settings.click();
        settingsPage.textScaling.click();
        settingsPage.textScaling.click();

        settingsPage.textDirection.click();
        settingsPage.textDirection.click();

        settingsPage.systemLocation.click();
        settingsPage.systemLocation.click();

        settingsPage.platform.click();
        settingsPage.platform.click();

        settingsPage.theme.click();
        settingsPage.theme.click();

        settingsPage.closeButton.click();
    }

    @Test
    public void MaterialUITest() {
        material.click();
        appBar.waitFor().is().displayed();
        materialUIView.pressButton(textFields);
// here type text fields
//
        back.click();
        MobileScreen.scrollToTop();
    }

    @Test
    public void CupertinoTest() {
        flutterPage.cupertino.click();
    }
}
