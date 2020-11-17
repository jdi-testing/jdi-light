package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;


public class DateWidgetsPage {

    @MobileFindBy(accessibilityId = "1. Dialog")
    public static Button dialogPage;

    @MobileFindBy(accessibilityId = "change the date")
    public static Button datePickerButton;

    @MobileFindBy(accessibilityId = "change the time")
    public static Button radialTimePickerButton;

    @MobileFindBy(accessibilityId = "change the time (spinner)")
    public static Button timePickerButton;
}
