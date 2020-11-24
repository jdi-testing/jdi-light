package nativeapp.android.apiDemos.App;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ActionBarPage {

    @MobileFindBy(accessibilityId = "Action Bar Usage")
    public static Button actionBarUsagePage;

    @MobileFindBy(accessibilityId = "Display Options")
    public static Button displayOptionsPage;


}
