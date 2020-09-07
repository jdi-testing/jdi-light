package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.ios.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class IndexPage {
    @MobileFindBy(accessibilityId = "Views")
    public static Button viewsPage;
}
