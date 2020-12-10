package com.epam.jdi.light.mobile.elements.common.app.android.notification;


import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class NotificationActions extends MobileUIElement implements HasTouchActions{
    @MobileFindBy(xpath = "//android.widget.Button[@content-desc=\"Mark as read\"]")
    public static Button markAsRead;

    @MobileFindBy(accessibilityId = "Reply")
    public static Button reply;

    @MobileFindBy(xpath = "//android.widget.EditText[@resource-id='com.android.systemui:id/remote_input_text']")
    public static TextField replyInput;

    @MobileFindBy(id = "com.android.systemui:id/remote_input_send")
    public static Button send;

    // ActionArea
    // List<Action> upToThreeActionsHere;
}
