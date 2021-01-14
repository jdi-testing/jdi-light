package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.app.android.Widget;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AlarmPage {

    @MobileFindBy(id = "com.google.android.deskclock:id/repeat_days")
    public static Widget repeatDaysAlarmWidget;//todo: isn't it useless?

}
