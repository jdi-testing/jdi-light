package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.app.android.Checkbox;
import com.epam.jdi.light.mobile.elements.common.app.android.Widget;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class Alarm {
    @MobileFindBy (id = "com.google.android.deskclock:id/repeat_onoff")
    public static Checkbox repeatAlarmCheckbox;

    @MobileFindBy (id = "com.google.android.deskclock:id/vibrate_onoff")
    public static Checkbox manageVibrationCheckbox;

    @MobileFindBy (id = "com.google.android.deskclock:id/repeat_days")
    public static Widget repeatDaysAlarmWidget;
}
