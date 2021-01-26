package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import nativeapp.android.apidemos.NotifyPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.common.MobileDevice.sendSMS;
import static com.epam.jdi.light.mobile.elements.init.MobileUIFactory.$;
import static nativeapp.android.apidemos.NotifyPage.*;

public class NotificationTests extends ApiDemosTestInit {

    public static final String NUMBER = "333-4545";
    public static final String MESSAGES = "Messages";
    public static final String MESSAGE = "Hello From Tests";
    public static final String TEST_MESSAGE = "a";
    public static final String NOW = "now";
    public static final String YOU = "You";

    @BeforeMethod
    public void initSteps() {
        sendSMS(NUMBER, MESSAGE);
        AndroidScreen.openNotificationPanel();
        NotifyPage.notificationPanel.waitFor(5);
    }

    @Test
    public void headerInformationTest() {
        appName.has().text(MESSAGES);
        timeStamp.has().text(NOW);
    }

    @Test
    public void contentInformationTest() {
        NotifyPage.notificationMessagingContent.has().text(MESSAGE);
        notificationName.has().text(NUMBER);
        appIcon.is().displayed();
    }

    @Test
    public void actionsMarkAsReadTest() {
        notificationPanel.is().displayed();
        markAsRead.tap();
        NotifyPage.notificationMessagingContent.is().disappear();
    }

    @Test
    public void actionsReplyTest() {
        notificationPanel.is().displayed();
        reply.tap();
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.A));
        send.tap();
        System.out.println(messages.size());
        System.out.println(messages.get(1).getAllAttributes().toString());
//        $(messageName, YOU).isDisplayed();
//        $(messageText, MESSAGE).isDisplayed();
//        $(messageText, TEST_MESSAGE).isDisplayed();
    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        if (clearAllButton.isDisplayed()) clearAllButton.tap();
        if (markAsRead.isDisplayed()) markAsRead.tap();
        AndroidScreen.closeNotificationPanel();
    }
}