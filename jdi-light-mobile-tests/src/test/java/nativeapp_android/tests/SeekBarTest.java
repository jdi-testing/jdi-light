package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.SeekBarPage;
import nativeapp.android.apidemos.views.ViewsPage;
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
        MobileScreen.scrollToElementInList(ViewsPage.seekBarPage).visible();
        ViewsPage.seekBarPage.click();
        SeekBarPage.seekBar.setMinimumValue();
        SeekBarPage.seekBar.is().text("0.0");
        SeekBarPage.seekBar.setMaximumValue();
        SeekBarPage.seekBar.is().text("100.0");
        SeekBarPage.seekBar.setSliderValue("20");
        SeekBarPage.seekBar.is().text("20.0");
    }

    @Test
    public void scrollTests() {
        IndexPage.viewsPage.click();
        MobileScreen.scrollToBottom();
        MobileScreen.scrollToTop();
        MobileScreen.scrollToElementInList(IndexPage.viewsPage).notAppear();
    }
}
