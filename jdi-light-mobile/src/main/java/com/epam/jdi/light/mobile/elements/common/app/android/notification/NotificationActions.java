package com.epam.jdi.light.mobile.elements.common.app.android.notification;

import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class NotificationActions extends MobileUIElement implements HasTouchActions, HasValue {
    @MobileFindBy(xpath = "//android.widget.Button[@content-desc='Mark as read']")
    public static Button markAsRead;

    @MobileFindBy(id = "//android.widget.Button[@content-desc='Reply']")
    public static Button reply;

    @MobileFindBy(id = "//android.widget.EditText[@resource-id='com.android.systemui:id/remote_input_text']")
    public static TextField replyInput;

    @MobileFindBy(id = "//android.widget.ImageButton[@content-desc='Send']")
    public static Button send;


    // ActionArea
    // List<Action> upToThreeActionsHere;
}
