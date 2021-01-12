package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.SearchViewButton;
import com.epam.jdi.light.mobile.elements.common.app.android.SearchViewField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SearchViewActionBarPage {

    @MobileFindBy(accessibilityId = "Search")
    public static SearchViewButton searchViewButton;

    @MobileFindBy(id = "android:id/search_src_text")
    public static SearchViewField searchViewField;

    @MobileFindBy(id = "io.appium.android.apis:id/status_text")
    public static SearchViewField query;

    @MobileFindBy(id = "android:id/home")
    public static SearchViewField home;

    @MobileFindBy(id = "io.appium.android.apis:id/txt_query")
    public static SearchViewField queryText;
}
