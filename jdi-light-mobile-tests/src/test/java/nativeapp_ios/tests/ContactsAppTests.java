package nativeapp_ios.tests;


import nativeapp.ios.contacts.AddNewContactPage;
import nativeapp.ios.contacts.ContactContextMenu;
import nativeapp.ios.contacts.ContactsListPage;
import nativeapp.ios.contacts.GroupsPage;
import nativeapp_ios.ContactsAppTestsInit;
import org.testng.annotations.Test;


public class ContactsAppTests extends ContactsAppTestsInit {

    @Test
    public void systemButtonTest() {
        ContactsListPage.contactsNavigationBar.groupsButton.tap();
        GroupsPage.groupsBar.is().displayed();
        GroupsPage.doneButton.done();
        ContactsListPage.contactsListView.is().displayed();

        ContactsListPage.contactsNavigationBar.addButton.tap();
        AddNewContactPage.newContactNavBar.is().displayed();
        AddNewContactPage.cancelButton.cancel();
        ContactsListPage.contactsNavigationBar.addButton.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        ContactsListPage.johnAppleseedCard.longPress(2);
        ContactContextMenu.johnAppleseedPhoto.is().displayed();
        ContactContextMenu.messageOptionExpand.tap();
        ContactContextMenu.johnAppleseedEmail.is().displayed();
    }

    @Test
    public void navigationBarTest() {
        ContactsListPage.contactsNavigationBar.is().displayed();
        ContactsListPage.contactsNavigationBar.groupsButton.is().displayed();
        ContactsListPage.contactsNavigationBar.tapBarButton("Groups");
        GroupsPage.groupsBar.is().displayed();
        GroupsPage.groupsBar.tapBarButton("Done");

        ContactsListPage.contactsNavigationBar.groupsButton.tap();
        GroupsPage.groupsBar.is().displayed();
        GroupsPage.doneButton.done();

        ContactsListPage.contactsNavigationBar.addButton.tap();
        AddNewContactPage.newContactNavBar.is().displayed();
        AddNewContactPage.cancelButton.cancel();
        ContactsListPage.contactsNavigationBar.addButton.is().displayed();

        ContactsListPage.contactsNavigationBar.tapBarButton("Add");
        AddNewContactPage.newContactNavBar.is().displayed();
        AddNewContactPage.newContactNavBar.tapBarButton("Cancel");
        ContactsListPage.contactsNavigationBar.addButton.is().displayed();
    }

    @Test
    public void searchBarTest() {
        ContactsListPage.contactsSearchBar.setValue("John");
        ContactsListPage.johnAppleseedCard.is().displayed();

        ContactsListPage.contactsSearchBar.tapClearButton();
        ContactsListPage.contactsSearchBar.is().text("Search");

        ContactsListPage.contactsSearchBar.tapCancelButton();
        ContactsListPage.contactsNavigationBar.addButton.is().displayed();
    }
}
