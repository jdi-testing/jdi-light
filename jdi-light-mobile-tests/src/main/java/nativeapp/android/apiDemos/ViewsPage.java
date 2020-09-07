package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.ios.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ViewsPage {
    @MobileFindBy(accessibilityId = "Buttons")
    public static Button buttonsPage;
}
