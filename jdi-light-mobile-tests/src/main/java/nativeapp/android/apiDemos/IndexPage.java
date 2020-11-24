package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class IndexPage {

    @MobileFindBy(accessibilityId = "Animation")
    public static Button animationPage;

    @MobileFindBy(accessibilityId = "Views")
    public static Button viewsPage;

    @MobileFindBy(accessibilityId = "App")
    public static Button appPage;

}
