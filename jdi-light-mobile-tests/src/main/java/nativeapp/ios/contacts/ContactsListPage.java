package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.ios.app.Button;
import com.epam.jdi.light.mobile.elements.common.ios.app.SystemButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactsListPage {
    @MobileFindBy(accessibilityId = "ContactsListView")
    public static MobileAppUIElement contactsListView;
    @MobileFindBy(accessibilityId = "Groups")
    public static SystemButton groupsButton;
    @MobileFindBy(accessibilityId = "Add")
    public static Button addButton;
    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"John Appleseed\"]")
    public static MobileAppUIElement johnAppleseedCard;
}
