package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.app.android.ToggleButton;
import nativeapp.android.apiDemos.ButtonsPage;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ToggleButtonTest extends ApiDemosTestInit {

    @Test
    public void toggleButtonTest() {
        IndexPage.viewsPage.click();
        ViewsPage.buttonsPage.click();
        ButtonsPage.toggleButton.is().displayed();
        ButtonsPage.toggleButton.is().off();
        ButtonsPage.toggleButton.setToOn();
        ButtonsPage.toggleButton.is().on();
        ButtonsPage.toggleButton.setToOff();
        ButtonsPage.toggleButton.is().off();
    }
}
