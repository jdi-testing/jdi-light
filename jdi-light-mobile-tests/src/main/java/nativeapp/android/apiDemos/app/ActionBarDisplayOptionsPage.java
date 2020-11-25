package nativeapp.android.apiDemos.app;

import com.epam.jdi.light.mobile.elements.common.app.android.ActionBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ActionBarDisplayOptionsPage {

    @MobileFindBy(accessibilityId = "More options")
    public static ActionBar moreOptions;

    @MobileFindBy(className = "android.widget.FrameLayout")
    public static ActionBar listView;

    @MobileFindBy(accessibilityId = "DISPLAY_HOME_AS_UP")
    public static ActionBar displayHomeAsUp;

    @MobileFindBy(accessibilityId = "Navigate up")
    public static ActionBar navigateUp;

    @MobileFindBy(accessibilityId = "DISPLAY_SHOW_HOME")
    public static ActionBar displayShowHome;

    @MobileFindBy(className = "android.widget.ImageView")
    public static ActionBar imageView;

    @MobileFindBy(accessibilityId = "DISPLAY_USE_LOGO")
    public static ActionBar displayUseLogo;

    @MobileFindBy(accessibilityId = "DISPLAY_SHOW_TITLE")
    public static ActionBar displayShowTitle;

    @MobileFindBy(className = "android.widget.TextView")
    public static ActionBar textView;

    @MobileFindBy(accessibilityId = "DISPLAY_SHOW_CUSTOM")
    public static ActionBar displayShowCustom;

    @MobileFindBy(accessibilityId = "Custom View!")
    public static ActionBar customView;

    @MobileFindBy(accessibilityId = "Navigation")
    public static ActionBar navigation;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout[1]/android.widget.HorizontalScrollView")
    public static ActionBar horizontalScrollView;

    @MobileFindBy(accessibilityId = "Cycle Custom View Gravity")
    public static ActionBar cycleCustomViewGravity;
}
