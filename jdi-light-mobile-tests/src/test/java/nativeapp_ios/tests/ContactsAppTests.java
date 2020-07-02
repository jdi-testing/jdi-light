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
        ContactsListPage.groupsButton.tap();
        GroupsPage.groupsBar.is().displayed();
        GroupsPage.doneButton.done();
        ContactsListPage.contactsListView.is().displayed();

        ContactsListPage.addButton.tap();
        AddNewContactPage.newContactNavBar.is().displayed();
        AddNewContactPage.cancelButton.cancel();
        ContactsListPage.addButton.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        ContactsListPage.johnAppleseedCard.longPress(2);
        ContactContextMenu.johnApplessedPhoto.is().displayed();
        ContactContextMenu.messageOptionExpand.tap();
        ContactContextMenu.johnAppleseedEmail.is().displayed();
    }
}
