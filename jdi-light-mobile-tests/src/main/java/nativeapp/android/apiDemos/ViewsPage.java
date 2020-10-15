package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ViewsPage {

    @MobileFindBy(accessibilityId = "Buttons")
    public static Button buttonsPage;

    @MobileFindBy(accessibilityId = "Search View")
    public static Button searchViewPage;

    @MobileFindBy(accessibilityId = "TextFields")
    public static Button textFieldsPage;
}
