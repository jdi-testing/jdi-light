package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.ActionBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ActionBarUsagePage {

    @MobileFindBy(accessibilityId = "Edit")
    public static Button edit;

    @MobileFindBy(accessibilityId = "More options")
    public static Button moreOptions;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout")
    public static ActionBar options;
}
