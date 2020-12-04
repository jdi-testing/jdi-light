package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.MobileBy;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.complex.Images.select;
import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.GalleryPage.photos;
import static nativeapp.android.apidemos.views.ViewsPage.galleryPage;
import static org.testng.Assert.assertTrue;

public class TooltipsTest extends ApiDemosTestInit {

    @Test
    public void tooltipTests() {
        viewsPage.tap();
        MobileScreen.scrollToElementInList(galleryPage);
        galleryPage.click();
        photos.tap();
        select(0).click();
        assertTrue(WebDriverFactory.getDriver().findElement(MobileBy.xpath("//*[@class='android.widget.Toast']")).getText().equals("0"));
    }
}
