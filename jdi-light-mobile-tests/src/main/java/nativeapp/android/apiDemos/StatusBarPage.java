package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.StatusBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class StatusBarPage {

    @MobileFindBy(id = "com.android.systemui:id/notification_panel")
    public static StatusBar notificationPanel;

    @MobileFindBy(id = "com.android.systemui:id/no_notifications")
    public static StatusBar noNotifications;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout")
    public static StatusBar statusBarLatestEventContent;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
    public static StatusBar appName;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    public static StatusBar appIcon;

    @MobileFindBy(id = "android:id/title")
    public static StatusBar title;

    @MobileFindBy(id = "android:id/text")
    public static StatusBar appText;

    @MobileFindBy(accessibilityId = "Clear all notifications.")
    public static Button clearAllButton;
}
