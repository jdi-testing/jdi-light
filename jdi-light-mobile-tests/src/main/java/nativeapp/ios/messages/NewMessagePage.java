package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.common.ios.app.AddContactButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NewMessagePage {
    @MobileFindBy(accessibilityId = "ComposeRecipientAddButton")
    public static AddContactButton addContactButton;
}
