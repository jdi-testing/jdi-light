package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.SeekBarPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeekBarTest extends ApiDemosTestInit {

    @BeforeMethod(alwaysRun = true)
    public void init() {
        MobileScreen.scrollToElementInList(IndexPage.viewsPage);
        IndexPage.viewsPage.click();
        MobileScreen.scrollToElementInList(ViewsPage.seekBarPage);
        ViewsPage.seekBarPage.click();
    }

    @Test
    public void setMinValue() {
        SeekBarPage.seekBar.setSliderValue("20");
        SeekBarPage.seekBar.is().text("20.0");
    }

    @Test
    public void setMaxValue() {
        SeekBarPage.seekBar.setMaximumValue();
        SeekBarPage.seekBar.is().text("100.0");
    }

    @Test
    public void setSliderValue() {
        SeekBarPage.seekBar.setMinimumValue();
        SeekBarPage.seekBar.is().text("0.0");
    }
}
