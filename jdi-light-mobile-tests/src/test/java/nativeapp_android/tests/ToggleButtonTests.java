package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp.android.apiDemos.ButtonsPage;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.SeekBarPage;
import nativeapp.android.apiDemos.ViewsPage;
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

    @Test
    public void seekBarTests() throws InterruptedException {
        IndexPage.viewsPage.click();
        AndroidScreen.scrollDown(2000);
        ViewsPage.seekBarPage.click();
        SeekBarPage.seekBar.setMinimumValue();
        SeekBarPage.seekBar.is().text("0.0");
        SeekBarPage.seekBar.setMaximumValue();
        SeekBarPage.seekBar.is().text("100.0");
        SeekBarPage.seekBar.setSliderValue("20");
        SeekBarPage.seekBar.is().text("20.0");
    }

}
