package com.epam.jdi.light.mobile.elements.common.app.android.notification;


import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.Icon;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class Notification extends BaseNotification {
    @MobileFindBy(id = "android:id/notification_header")
    protected NotificationHeader notificationHeader;

    @MobileFindBy(id = "android:id/conversation_header")
    protected NotificationHeader notificationConversationHeader;

    @MobileFindBy(id = "android:id/notification_messaging")
    protected NotificationContent notificationMessagingContent;

    @MobileFindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/right_icon_container']/android.widget.ImageView")
    protected Icon rightIcon;
    @MobileFindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/actions']")
    public static NotificationActions notificationActions;

    // TODO: implement notificationActions Section
    // TODO: refactor the structure of Notification and it's related Sections if possible and needed
    // TODO: POSSIBLY implement notificationStackScroller
    // TODO: implement swipe L and R actions for notification.

    @JDIAction("Check that '{name}' header Icon is displayed")
    public boolean isHeaderConversationIconDisplayed() {
        return notificationConversationHeader.isIconDisplayed();
    }

    @JDIAction("Get '{name}' application Name from header")
    public String appConversationName() {
        return notificationConversationHeader.getAppName();
    }

    @JDIAction("Get '{name}' application Name from header")
    public String notificationConversationName() {
        return notificationConversationHeader.getConversationName();
    }

    @JDIAction("Get '{name}' header text")
    public String headerText() {
        return notificationHeader.getHeaderText();
    }

    @JDIAction("Get '{name}' time")
    public String time() {
        return notificationHeader.getNotificationTime();
    }

    @JDIAction("Click on '{name}' \"expand\" button")
    public void expand() {
        notificationHeader.expandNotification();
    }

    @JDIAction("Get '{name}' content title")
    public String title() {
        return notificationMessagingContent.getContentTitle();
    }

    @JDIAction("Get '{name}' content text")
    public String contentText() {
        return notificationMessagingContent.getContentText();
    }

    @JDIAction("Check if '{name}' Large Icon is displayed")
    public boolean isLargeIconDisplayed() {
        return notificationMessagingContent.isLargeIconDisplayed();
    }

    @JDIAction("Click '{name}' right Icon")
    public void clickRightIcon() {
        rightIcon.click();
    }
}
