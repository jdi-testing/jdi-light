package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.SeekBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AlarmSettings { //todo: isn't it useless?

    @MobileFindBy(accessibilityId = "More options")
    public static Button alarMoreOptions;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout")
    public static Button settingsButton;

    @MobileFindBy(id = "com.google.android.deskclock:id/alarm_volume_slider")
    public static SeekBar alarmVolume;

}
