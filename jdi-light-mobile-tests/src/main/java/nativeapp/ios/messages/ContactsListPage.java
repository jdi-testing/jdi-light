package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.ios.app.SystemButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactsListPage {
    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Contacts\"]")
    public static MobileAppUIElement contactNavBar;
    @MobileFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Cancel\"])[1]")
    public static SystemButton cancelButton;
}
