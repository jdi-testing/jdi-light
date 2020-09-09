package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.android.ToggleButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ButtonsPage {
    @MobileFindBy(accessibilityId = "Toggle")
    public static ToggleButton toggleButton;
}
