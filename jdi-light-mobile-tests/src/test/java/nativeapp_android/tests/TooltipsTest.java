package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.PhotosPage.photo;
import static nativeapp.android.apidemos.views.PhotosPage.photoButton;
import static nativeapp.android.apidemos.views.PhotosPage.tooltip;
import static nativeapp.android.apidemos.views.ViewsPage.galleryPage;

public class TooltipsTest extends ApiDemosTestInit {

    @Test
    public void tooltipTests() {
        viewsPage.tap();
        clickOnElementInList(galleryPage);
        photoButton.tap();
        //getDriver().findElement(MobileBy.AccessibilityId("1. Photos")).click();
        photo.longPress();
        //PhotosPage.photo.get(0).click();
        //getDriver().findElements(MobileBy.xpath("//android.widget.ImageView")).get(0).click();
        tooltip.isVisible();
        tooltip.getText().equalsIgnoreCase("Testing");
        tooltip.core().longPress();
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
