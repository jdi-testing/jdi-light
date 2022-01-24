package android10NonApplicationTests;

import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.views.ButtonsPage.toggleButton;

public class ToggleButtonTests extends ApiDemosTestInit {

    @Test
    public void toggleButtonTests() {
        IndexPage.viewsPage.click();
        ViewsPage.buttonsPage.click();

        toggleButton.is().displayed();
        toggleButton.is().off();
        toggleButton.is().text("OFF");

        toggleButton.setToOn();
        toggleButton.is().on();
        toggleButton.is().text("ON");

        toggleButton.setToOff();
        toggleButton.is().off();
        toggleButton.is().text("OFF");
    }
}
