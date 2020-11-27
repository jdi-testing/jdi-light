package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.*;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class RadialPickerPage {

    @MobileFindBy(id = "android:id/hours")
    public static Button hoursHeader;

    @MobileFindBy(id = "android:id/minutes")
    public static Button minutesHeader;

    @MobileFindBy(id = "android:id/radial_picker")
    public static Picker radialPicker;
}
