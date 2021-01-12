package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.SearchViewField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SearchViewAlwaysExpandedPage {

    @MobileFindBy(id = "android:id/search_src_text")
    public static SearchViewField searchViewField;

    @MobileFindBy(id = "io.appium.android.apis:id/status_text")
    public static SearchViewField query;

    @MobileFindBy(id = "io.appium.android.apis:id/txt_query")
    public static SearchViewField queryText;

    @MobileFindBy(accessibilityId = "Clear query")
    public static SearchViewField crossIcon;
}
