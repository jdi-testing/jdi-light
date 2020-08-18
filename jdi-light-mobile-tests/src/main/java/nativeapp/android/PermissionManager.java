package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.RadioButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class PermissionManager {

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Apps & notifications']")
    public static Button appsAndNotificationsButton;

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Advanced']")
    public static Button advanceSettingsButton;

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Permission manager']")
    public static Button permissionManagerButton;

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    public static Button calendarButton;

    @MobileFindBy(accessibilityId = "Calendar")
    public static Button calendarAppPermissionButton;

    @MobileFindBy(id = "com.android.permissioncontroller:id/deny_radio_button")
    public static RadioButton denyRadioButton;

    @MobileFindBy(id = "com.android.permissioncontroller:id/allow_radio_button")
    public static RadioButton allowRadioButton;

    @MobileFindBy(id = "android:id/button1")
    public static Button confirmButton;
}
