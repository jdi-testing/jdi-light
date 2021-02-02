package nativeapp.android.apidemos.app;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AppPage {

    @MobileFindBy(accessibilityId = "Notification")
    public static Button notificationPage;

    @MobileFindBy(accessibilityId = "Action Bar")
    public static Button actionBarPage;

    @MobileFindBy(accessibilityId = "Fragment")
    public static Button fragmentPage;

}
