package nativeapp.android.apidemos.app;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NotificationPage {

    @MobileFindBy(accessibilityId = "Status Bar")
    public static Button statusBarButton;

    @MobileFindBy(id = "io.appium.android.apis:id/clear")
    public static Button clearNotificationButton;

    @MobileFindBy(id = "io.appium.android.apis:id/happy")
    public static Button happyButton;

}
