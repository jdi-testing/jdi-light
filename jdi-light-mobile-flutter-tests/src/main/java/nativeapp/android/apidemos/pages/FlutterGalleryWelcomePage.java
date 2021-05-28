package nativeapp.android.apidemos.pages;

import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class FlutterGalleryWelcomePage {

    @MobileFindBy(accessibilityId = "Settings")
    public static Button settings;

    @MobileFindBy(accessibilityId = "Reply An efficient, focused email app")
    public static Button reply;

    @MobileFindBy(accessibilityId = "MATERIAL")
    public static Button material;
    @MobileFindBy(accessibilityId = "CUPERTINO")
    public static Button cupertino;
    @MobileFindBy(accessibilityId = "STYLES & OTHER")
    public static Button stylesAndOther;

    @MobileFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Back')]")
    public static Button back;

}
