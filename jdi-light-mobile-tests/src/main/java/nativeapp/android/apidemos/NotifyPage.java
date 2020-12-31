package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NotifyPage {
    @MobileFindBy(id = "com.android.systemui:id/notification_panel")
    public static Text notificationPanel;

    @MobileFindBy(accessibilityId = "Clear all notifications.")
    public static Button clearAllButton;

    @MobileFindBy(id = "android:id/message_text")
    public static Text notificationMessagingContent;

    @MobileFindBy(xpath = "//android.widget.Button[@content-desc=\"Mark as read\"]")
    public static Button markAsRead;

    @MobileFindBy(accessibilityId = "Reply")
    public static Button reply;

    @MobileFindBy(id = "com.android.systemui:id/remote_input_send")
    public static Button send;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[2]/" +
            "android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout[1]/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView[2]")
    public static Button appIcon;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[2]/" +
            "android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/" +
            "android.widget.TextView[3]")
    public static Text appName;

    @MobileFindBy(id = "android:id/conversation_text")
    public static Text notificationName;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[2]/" +
            "android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/" +
            "android.widget.TextView[5]")
    public static Text timeStamp;

    @MobileFindBy(id = "android:id/message_name")
    public static Text messageName;

    @MobileFindBy(id = "android:id/message_text")
    public static Text messageText;

}