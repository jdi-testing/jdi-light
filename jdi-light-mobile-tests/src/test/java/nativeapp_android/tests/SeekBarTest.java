package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.Views.SeekBarPage;
import nativeapp.android.apiDemos.Views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class SeekBarTest extends ApiDemosTestInit {

    @BeforeClass
    public void beforeClass() {
        logger.toLog("Run SeekBarTest");
    }

    @Test
    public void seekBarTests() throws InterruptedException {
        IndexPage.viewsPage.click();
        clickOnElementInList(ViewsPage.seekBarPage);
        SeekBarPage.seekBar.setMinimumValue();
        SeekBarPage.seekBar.is().text("0.0");
        SeekBarPage.seekBar.setMaximumValue();
        SeekBarPage.seekBar.is().text("100.0");
        SeekBarPage.seekBar.setSliderValue("20");
        SeekBarPage.seekBar.is().text("20.0");
    }

    public void clickOnElementInList(Button element) {
        while (true) {
            try {
                element.click();
                return;
            } catch (RuntimeException e) {
                MobileScreen.scrollDown(1000);
            }
        }
    }
}
