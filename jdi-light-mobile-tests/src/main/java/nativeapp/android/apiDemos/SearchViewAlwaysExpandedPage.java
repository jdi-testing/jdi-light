package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.Icon;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

import java.lang.reflect.Field;

public class SearchViewAlwaysExpandedPage {

    @MobileFindBy(id = "android:id/search_mag_icon")
    public static Icon searchIcon;
    @MobileFindBy(id = "android:id/search_src_text")
    public static Field textSearch;
}
