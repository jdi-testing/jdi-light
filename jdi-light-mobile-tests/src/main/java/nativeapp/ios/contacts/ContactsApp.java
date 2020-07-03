package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(app = "com.apple.MobileAddressBook")
public class ContactsApp {
    public static GroupsPage groupsPage;
    public static ContactsListPage contactsListPage;
    public static AddNewContactPage addNewContactPage;

//    @MobileFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]" +
//            "/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    public static ContactContextMenu contactContextMenu;
}
