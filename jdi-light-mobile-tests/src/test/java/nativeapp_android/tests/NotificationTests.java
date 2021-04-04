package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp.android.apidemos.NotifyPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.common.MobileDevice.sendSMS;

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
    public void contentInformationTest() {
        NotifyPage.appIcon.is().displayed();
        NotifyPage.appName.has().text(MESSAGES);
        NotifyPage.timeStamp.has().text(NOW);
        NotifyPage.notificationMessagingContent.has().text(MESSAGE);
        NotifyPage.notificationName.has().text(NUMBER);
    }

    @Test
    public void actionsMarkAsReadTest() {
        NotifyPage.notificationPanel.is().displayed();
        NotifyPage.markAsRead.tap();
        NotifyPage.notificationMessagingContent.is().disappear();
    }

    @Test
    public void actionsReplyTest() {
        NotifyPage.notificationPanel.is().displayed();
        NotifyPage.reply.tap();
        MobileKeyboard.pressKey(AndroidKey.A);
        NotifyPage.send.tap();
        NotifyPage.messageNames.get(1).is().text(NUMBER);
        NotifyPage.messageNames.get(2).is().text(YOU);
        NotifyPage.messageTexts.get(1).is().text(MESSAGE);
        NotifyPage.messageTexts.get(2).is().text(TEST_MESSAGE);
    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        if (NotifyPage.clearAllButton.isDisplayed()) NotifyPage.clearAllButton.tap();
        if (NotifyPage.markAsRead.isDisplayed()) NotifyPage.markAsRead.tap();
        AndroidScreen.closeNotificationPanel();
    }
}