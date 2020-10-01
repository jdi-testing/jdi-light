package nativeapp.android.apiDemos;


import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.Picker;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
;



public class DateWidgetsPage {
    @MobileFindBy(accessibilityId = "1. Dialog")
    public static Button dialogPage;

    @MobileFindBy(accessibilityId = "change the date")
    public static Button datePickerButton;

    @MobileFindBy(className = "android.view.View")
    public static Picker datePickerNumbers;

    @MobileFindBy(accessibilityId = "change the time")
    public static Button radialTimePickerButton;

    @MobileFindBy(className = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    public static Picker radialPickerNumbers;


    @MobileFindBy(id = "android:id/hours")
    public static Button hoursHeader;

    @MobileFindBy(id = "android:id/minutes")
    public static Button minutesHeader;

    @MobileFindBy(accessibilityId = "change the time (spinner)")
    public static Button timePickerButton;
}
