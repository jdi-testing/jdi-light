package nativeapp_ios.tests;

import nativeapp_ios.MessagesAppTestsInit;
import org.testng.annotations.Test;

import static nativeapp.ios.messages.MessagesApp.messagesListPage;
import static nativeapp.ios.messages.MessagesApp.newMessagePage;

public class MessagesAppTests extends MessagesAppTestsInit {

    @Test
    public void textFieldTest() {
        messagesListPage.firstMenInMessages.tap();

        newMessagePage.messageTextField.setValue("Test");
        newMessagePage.messageTextField.is().text("Test");

        newMessagePage.messageTextField.clear();
        newMessagePage.messageTextField.is().text("iMessage");
    }

    @Test
    public void editMenuTest() {
        messagesListPage.firstMenInMessages.tap();

        newMessagePage.messageTextField.setValue("Test");
        newMessagePage.messageTextField.doubleTap();
        newMessagePage.messageEditMenu.copy();
        newMessagePage.messageTextField.doubleTap();
        newMessagePage.messageEditMenu.cut();
        newMessagePage.messageTextField.is().text("iMessage");
        newMessagePage.messageTextField.doubleTap();
        newMessagePage.messageEditMenu.paste();
        newMessagePage.messageTextField.is().text("Test");
    }
}
