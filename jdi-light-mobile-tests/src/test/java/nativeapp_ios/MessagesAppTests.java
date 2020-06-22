package nativeapp_ios;

import nativeapp.ios.messages.ContactsListPage;
import nativeapp.ios.messages.MessagesListPage;
import nativeapp.ios.messages.NewMessagePage;
import nativeapp.ios.messages.WhatsNewPage;
import org.testng.annotations.Test;

public class MessagesAppTests extends MessagesAppTestsInit {

    @Test
    public void addContactButtonTest() throws Exception {
        Thread.sleep(5000);
        if (WhatsNewPage.continueButton.isDisplayed()) {
            WhatsNewPage.continueButton.tap();
        }

        MessagesListPage.newMessageButton.tap();

        NewMessagePage.addContactButton.openContacts();

        Thread.sleep(5000);
        ContactsListPage.contactNavBar.is().displayed();
        ContactsListPage.cancelButton.cancel();

        NewMessagePage.addContactButton.is().displayed();
    }
}
