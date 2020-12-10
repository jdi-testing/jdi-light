package com.epam.jdi.light.mobile.elements.common.app.android.notification;

import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.Icon;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NotificationHeader extends Section {
    @MobileFindBy(id = "android:id/icon")
    private Icon appIcon;
    @MobileFindBy(id = "android:id/app_name_text")
    private Text appName;
    @MobileFindBy(id = "android:id/header_text")
    private Text conversationName;
    @MobileFindBy(id = "android:id/conversation_text")
    private Text headerText; //optional
    @MobileFindBy(id = "android:id/time")
    private Text timeStamp; //optional
    @MobileFindBy(id = "android:id/expand_button")
    private Button expandIndicator; // if applicable

    public boolean isIconDisplayed() {
        return appIcon.isVisible();//isDisplayed(); // TODO: fix that Icon can't be checked wherether it's visible or not
    }

    public String getAppName() {
        return appName.getText();
    }
    public String getConversationName() {
        return conversationName.getText();
    }

    public String getHeaderText() {
        return headerText.getText();
    }

    public String getNotificationTime() {
        return timeStamp.getText();
    }

    public void expandNotification() { //TODO make it more clear whether you expand or collapse notification
        System.out.println("expandButton is visible =" + expandIndicator.isDisabled());
        expandIndicator.click();
    }
}
