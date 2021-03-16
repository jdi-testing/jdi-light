package nativeapp.android.apidemos.app;

import com.epam.jdi.light.mobile.elements.common.app.android.ActionBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ActionBarUsagePage {

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android" +
            ".widget.FrameLayout[2]/android.widget.TextView")
    public static ActionBar text;

    @MobileFindBy(accessibilityId = "Search")
    public static ActionBar searchButton;

    @MobileFindBy(id = "android:id/search_src_text")
    public static ActionBar searchVield;

    @MobileFindBy(accessibilityId = "Edit")
    public static ActionBar edit;

    @MobileFindBy(accessibilityId = "More options")
    public static ActionBar moreOptions;

    @MobileFindBy(accessibilityId = "Clear query")
    public static ActionBar clearQuery;

    @MobileFindBy(className = "android.widget.ListView")
    public static ActionBar listView;

}
