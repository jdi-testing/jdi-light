package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.PhotosPage;
import nativeapp.android.apiDemos.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

public class TooltipsTest extends ApiDemosTestInit {

    @Test
    public void tooltipTests() {
        IndexPage.viewsPage.tap();
        clickOnElementInList(ViewsPage.galleryPage);
        PhotosPage.photoButton.tap();
        //getDriver().findElement(MobileBy.AccessibilityId("1. Photos")).click();
        PhotosPage.photo.longPress();
        //PhotosPage.photo.get(0).click();
        //getDriver().findElements(MobileBy.xpath("//android.widget.ImageView")).get(0).click();
        PhotosPage.tooltip.isVisible();
        PhotosPage.tooltip.getText().equalsIgnoreCase("Testing");
        PhotosPage.tooltip.core().longPress();
        //System.out.println(getDriver().findElement(MobileBy.xpath("//*[@class='android.widget.Toast']")).getText());
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
