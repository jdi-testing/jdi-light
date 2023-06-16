package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.complex.MobileWebList;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NotifyPage {

    @MobileFindBy(id = "com.android.systemui:id/notification_panel")
    public static Text notificationPanel;

    @MobileFindBy(accessibilityId = "Clear all notifications.")
    public static Button clearAllButton;

    @MobileFindBy(xpath = "//*[@resource-id='android:id/message_text']")
    public static Text notificationMessagingContent;

    @MobileFindBy(xpath = "//android.widget.Button[@content-desc=\"Mark as read\"]")
    public static Button markAsRead;

    @MobileFindBy(accessibilityId = "Reply")
    public static Button reply;

    @MobileFindBy(id = "com.android.systemui:id/remote_input_send")
    public static Button send;

    @MobileFindBy(xpath = "//*[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout[1]//*[@resource-id='android:id/icon']")
    public static Button appIcon;

    @MobileFindBy(xpath = "//*[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout[1]//*[@resource-id='android:id/app_name_text']")
    public static Text appName;

    @MobileFindBy(xpath = "//*[@resource-id='android:id/message_name']")
    public static Text notificationName;

    @MobileFindBy(xpath = "//*[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout[1]//*[@resource-id='android:id/time']")
    public static Text timeStamp;

    @MobileFindBy(xpath = "//android.widget.Switch[@content-desc=\"Wi-Fi,Wifi signal full.,AndroidWifi\"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView")
    public static Button wifiIcon;

    @MobileFindBy(xpath = "//android.widget.Switch[@content-desc=\"Airplane mode\"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    public static Button airplaneModeIcon;

    @MobileFindBy(xpath = "//*[@resource-id='android:id/message_name']")
    public static MobileWebList messageNames;

    @MobileFindBy(xpath = "//*[@resource-id='android:id/message_text']")
    public static MobileWebList messageTexts;


}