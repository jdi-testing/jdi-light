package android10NonApplicationTests;

import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.ButtonsPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

public class ToggleButtonTests extends ApiDemosTestInit {

    @Test
    public void toggleButtonTests() {
        IndexPage.viewsPage.click();
        ViewsPage.buttonsPage.click();

        ButtonsPage.toggleButton.is().displayed();
        ButtonsPage.toggleButton.is().off();
        ButtonsPage.toggleButton.is().text("OFF");

        ButtonsPage.toggleButton.setToOn();
        ButtonsPage.toggleButton.is().on();
        ButtonsPage.toggleButton.is().text("ON");

        ButtonsPage.toggleButton.setToOff();
        ButtonsPage.toggleButton.is().off();
        ButtonsPage.toggleButton.is().text("OFF");
    }
}