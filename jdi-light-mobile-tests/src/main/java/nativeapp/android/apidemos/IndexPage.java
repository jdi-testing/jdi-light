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

    @MobileFindBy(accessibilityId = "Seek Bar")
    public static Button seekBarPage;
}
