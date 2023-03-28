package nativeapp.android.apidemos.views;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class GalleryPage {

    @MobileFindBy(accessibilityId = "1. Photos")
    public static Button photos;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]")
    public static Button photoOne;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[2]")
    public static Button photoTwo;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[3]")
    public static Button photoThree;

    @MobileFindBy(id = "io.appium.android.apis:id/layout2")
    public static UIElement galleryLayout;

}
