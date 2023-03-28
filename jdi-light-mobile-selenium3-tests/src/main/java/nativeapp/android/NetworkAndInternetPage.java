package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.Switch;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NetworkAndInternetPage {

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Network & internet']")
    public static Button networkAndInternetButton;

    @MobileFindBy(id = "com.android.settings:id/switchWidget")
    public static Switch wiFiSwitch;

    @MobileFindBy(id = "android:id/switch_widget")
    public static Switch airplaneModeSwitch;

    @MobileFindBy(id = "android:id/switch_widget")
    public static Switch airplaneModeForAndroid11;

}
