package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.common.app.ios.AddContactButton;
import com.epam.jdi.light.mobile.elements.common.app.ios.TextField;
import com.epam.jdi.light.mobile.elements.composite.ios.app.EditMenu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NewMessagePage {

    @MobileFindBy(accessibilityId = "ComposeRecipientAddButton")
    public static AddContactButton addContactButton;

    @MobileFindBy(accessibilityId = "messageBodyField")
    public static TextField messageTextField;

    public static EditMenu messageEditMenu;

}
