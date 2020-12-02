package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class MessagesListPage {
    @MobileFindBy(accessibilityId = "composeButton")
    public static Button newMessageButton;
}
