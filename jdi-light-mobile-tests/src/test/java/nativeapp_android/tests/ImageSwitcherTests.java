package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.complex.Images.itemIsSelected;
import static com.epam.jdi.light.mobile.elements.complex.Images.select;
import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.ViewsPage.imageSwitcherPage;

public class ImageSwitcherTests extends ApiDemosTestInit {

    private WebElement element;

    @Test
    public void selectPhotosInImageSwitcher() {
        viewsPage.click();
        AndroidScreen.scrollDown(1000);
        imageSwitcherPage.click();

        element = select(1);
        itemIsSelected(element,true);

        element = select(2);
        itemIsSelected(element,false);

        element.click();
        itemIsSelected(element,true);
    }
}