package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SearchViewPage {

    @MobileFindBy(accessibilityId = "Action Bar")
    public static Button actionBarPage;

    @MobileFindBy(accessibilityId = "Always Expanded")
    public static Button alwaysExpandedPage;

    @MobileFindBy(accessibilityId = "Filter")
    public static Button filterPage;

}
