package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.SearchViewField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SearchViewFilterPage {

    @MobileFindBy(id = "android:id/search_src_text")
    public static SearchViewField searchViewField;

    @MobileFindBy(id = "io.appium.android.apis:id/list_view")
    public static SearchViewField listView;

    @MobileFindBy(id = "android:id/text1")
    public static SearchViewField option;

    @MobileFindBy(accessibilityId = "Clear query")
    public static SearchViewField crossIcon;

}
