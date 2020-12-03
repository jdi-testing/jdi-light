package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.complex.Images.itemIsSelected;
import static com.epam.jdi.light.mobile.elements.complex.Images.select;
import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.GalleryPage.photos;
import static nativeapp.android.apidemos.views.ViewsPage.galleryPage;

public class GalleryTests extends ApiDemosTestInit {

    private WebElement element;

    @Test
    public void selectPhotosInGallery() {
        viewsPage.click();
        galleryPage.click();
        photos.click();

        element = select(0);
        itemIsSelected(element,true);

        element = select(1);
        itemIsSelected(element,false);

        element.click();
        itemIsSelected(element,true);
    }
}