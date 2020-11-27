package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.app.android.Tooltip;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class PhotosPage {
    @MobileFindBy(accessibilityId = "1. Photos")
    public static MobileAppUIElement photoButton;

/*    @MobileFindBys(@MobileFindBy(xpath = "//android.widget.ImageView"))
    public static List<WebElement> photo;*/

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]")
    public static MobileAppUIElement photo;

    @MobileFindBy(xpath = "//*[@class='android.widget.TextView']")
    public static Tooltip tooltip;
}
