package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(app = "com.apple.MobileSMS")
public class MessagesApp {

    public static MessagesListPage messagesListPage;

    public static NewMessagePage newMessagePage;

    public static ContactsListPage contactsListPage;

    public static WhatsNewPage whatsNewPage;

}
