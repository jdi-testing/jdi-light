package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.SearchBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactsListPage {

    @MobileFindBy(accessibilityId = "ContactsListView")
    public static MobileAppUIElement contactsListView;

    @MobileFindBy(accessibilityId = "Groups")
    public static SystemButton groupsButton;

    @MobileFindBy(accessibilityId = "Add")
    public static Button addButton;

    @MobileFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Higgins')]")
    public static MobileAppUIElement manNameCard;

    @MobileFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search']")
    public static SearchBar contactsSearchBar;

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Contacts']")
    public static ContactsNavigationBar contactsNavigationBar;

}
