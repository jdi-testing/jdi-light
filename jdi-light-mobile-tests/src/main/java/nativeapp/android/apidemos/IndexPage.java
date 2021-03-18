package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class IndexPage {

    @MobileFindBy(accessibilityId = "Animation")
    public static Button animationPage;

    @MobileFindBy(accessibilityId = "Views")
    public static Button viewsPage;

    @MobileFindBy(accessibilityId = "App")
    public static Button appPage;

    @MobileFindBy(accessibilityId = "Progress Bar")
    public static Button goToProgressBarPageStageOne;

    @MobileFindBy(accessibilityId = "1. Incremental")
    public static Button goToProgressBarPageStageTwo;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Progress Bar']")
    public static Button goToProgressBarPageStageThree;

    @MobileFindBy(accessibilityId = "Popup Menu")
    public static Button popUpMenu;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
    public static Button goToViewPage;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Popup Menu']")
    public static Button goToPopupMenuPage;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Rating Bar']")
    public static Button goToRatingBar;

}
