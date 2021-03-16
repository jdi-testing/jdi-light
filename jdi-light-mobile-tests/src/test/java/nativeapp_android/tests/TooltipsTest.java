package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.views.GalleryPage;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.GalleryPage.photos;
import static nativeapp.android.apidemos.views.ViewsPage.galleryPage;

public class TooltipsTest extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        viewsPage.tap();
        MobileScreen.scrollToElementInList(galleryPage);
        galleryPage.tap();
        photos.tap();
    }

    @Test
    public void getAllToolTipsFromGallery() {
        GalleryPage.photoOne.tap();
        GalleryPage.galleryLayout.find(By.linkText("0")).isExist();

        GalleryPage.photoTwo.tap();
        GalleryPage.galleryLayout.find(By.linkText("1")).isExist();

        GalleryPage.photoThree.tap();
        GalleryPage.galleryLayout.find(By.linkText("2")).isExist();
    }
}
