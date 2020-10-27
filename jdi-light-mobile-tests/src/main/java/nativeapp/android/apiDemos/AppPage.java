package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AppPage {

    @MobileFindBy(accessibilityId = "Notification")
    public static Button notificationPage;
}
