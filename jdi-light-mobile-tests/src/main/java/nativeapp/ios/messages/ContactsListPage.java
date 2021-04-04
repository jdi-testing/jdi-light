package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactsListPage {

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Contacts\"]")
    public static NavigationBar contactNavBar;

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Contacts']//XCUIElementTypeButton[@name='Cancel']")
    public static SystemButton cancelButton;

}
