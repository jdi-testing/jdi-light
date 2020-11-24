package nativeapp_android.tests;

import nativeapp.android.apiDemos.Views.ButtonsPage;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.Views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class ToggleButtonTests extends ApiDemosTestInit {

    @BeforeClass
    public void beforeClass() {
        logger.toLog("Run ToggleButtonTests");
    }

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