package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;


public class ExpandableListPage {

    @MobileFindBy(accessibilityId = "1. Custom Adapter")
    public static Button customAdapter;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[1]")
    public static Button peopleNames;

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Arnold']")
    public static Button arnoldName;

}
