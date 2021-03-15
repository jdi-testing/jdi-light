package nativeapp.android.apidemos.app;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.StatusBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class StatusBarPage {

    @MobileFindBy(id = "com.android.systemui:id/notification_panel")
    public static StatusBar notificationPanel;

    @MobileFindBy(id = "com.android.systemui:id/no_notifications")
    public static StatusBar noNotifications;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
    public static StatusBar appName;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    public static StatusBar appIcon;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    public static StatusBar title;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
    public static StatusBar appText;

    @MobileFindBy(xpath = "//android.widget.Button[@content-desc='Clear notification']")
    public static Button clearAllButton;

}
