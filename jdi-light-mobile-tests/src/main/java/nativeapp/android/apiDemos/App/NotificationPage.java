package nativeapp.android.apiDemos.App;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NotificationPage {

    @MobileFindBy(accessibilityId = "Status Bar")
    public static Button statusBarButton;

    @MobileFindBy(id = "io.appium.android.apis:id/clear")
    public static Button clearNotificationButton;

    @MobileFindBy(id = "io.appium.android.apis:id/happy")
    public static Button happyButton;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageButton")
    public static Button happyIconButton;

    
}
