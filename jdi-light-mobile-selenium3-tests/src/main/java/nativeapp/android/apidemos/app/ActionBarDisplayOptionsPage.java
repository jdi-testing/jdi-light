package nativeapp.android.apidemos.app;

import com.epam.jdi.light.mobile.elements.common.app.android.ActionBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ActionBarDisplayOptionsPage {

    @MobileFindBy(accessibilityId = "More options")
    public static ActionBar moreOptions;

    @MobileFindBy(className = "android.widget.FrameLayout")
    public static ActionBar listView;

    @MobileFindBy(className = "android.widget.TextView")
    public static ActionBar textView;

    @MobileFindBy(accessibilityId = "Cycle Custom View Gravity")
    public static ActionBar cycleCustomViewGravity;

}
