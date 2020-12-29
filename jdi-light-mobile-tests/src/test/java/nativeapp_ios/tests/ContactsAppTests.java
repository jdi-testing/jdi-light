package nativeapp_ios.tests;

import nativeapp_ios.ContactsAppTestsInit;
import org.testng.annotations.Test;

import static nativeapp.ios.contacts.ContactsApp.addNewContactPage;
import static nativeapp.ios.contacts.ContactsApp.contactContextMenu;
import static nativeapp.ios.contacts.ContactsApp.contactsListPage;
import static nativeapp.ios.contacts.ContactsApp.groupsPage;

public class ContactsAppTests extends ContactsAppTestsInit {

    @Test
    public void systemButtonTest() {
        contactsListPage.contactsNavigationBar.groupsButton.tap();
        groupsPage.groupsBar.is().displayed();
        groupsPage.doneButton.done();
        contactsListPage.contactsListView.is().displayed();

        contactsListPage.contactsNavigationBar.addButton.tap();
        addNewContactPage.newContactNavBar.is().displayed();
        addNewContactPage.cancelButton.cancel();
        contactsListPage.contactsNavigationBar.addButton.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        contactsListPage.manNameCard.longPress(2);
        contactContextMenu.mensPhoto.is().displayed();
        contactContextMenu.mensMail.is().displayed();
    }

    @Test
    public void navigationBarTest() {
        contactsListPage.contactsNavigationBar.is().displayed();
        contactsListPage.contactsNavigationBar.groupsButton.is().displayed();
        contactsListPage.contactsNavigationBar.tapButton("Groups");
        groupsPage.groupsBar.is().displayed();
        groupsPage.groupsBar.tapButton("Done");

        contactsListPage.contactsNavigationBar.groupsButton.tap();
        groupsPage.groupsBar.is().displayed();
        groupsPage.doneButton.done();

        contactsListPage.contactsNavigationBar.addButton.tap();
        addNewContactPage.newContactNavBar.is().displayed();
        addNewContactPage.cancelButton.cancel();
        contactsListPage.contactsNavigationBar.addButton.is().displayed();

        contactsListPage.contactsNavigationBar.tapButton("Add");
        addNewContactPage.newContactNavBar.is().displayed();
        addNewContactPage.newContactNavBar.tapButton("Cancel");
        contactsListPage.contactsNavigationBar.addButton.is().displayed();
    }

    @Test
    public void searchBarTest() {
        contactsListPage.contactsSearchBar.setValue("Daniel");
        contactsListPage.manNameCard.is().displayed();

        contactsListPage.contactsSearchBar.tapClearButton();
        contactsListPage.contactsSearchBar.is().text("Search");

        contactsListPage.contactsSearchBar.tapCancelButton();
        contactsListPage.contactsNavigationBar.addButton.is().displayed();
    }
}
