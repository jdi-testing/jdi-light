package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.ToggleButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NetworkAndInternet { //todo: useless?

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Network & internet']")
    public static Button networkAndInternetButton;

    @MobileFindBy(id = "com.android.settings:id/switchWidget")
    public static ToggleButton wiFi;

    @MobileFindBy(id = "android:id/switch_widget")
    public static ToggleButton airplaneMode;

}
