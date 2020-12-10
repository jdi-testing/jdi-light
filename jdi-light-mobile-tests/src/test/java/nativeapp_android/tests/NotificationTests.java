package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.common.app.android.notification.Notification;
import com.epam.jdi.light.mobile.elements.common.app.android.notification.NotificationActions;
import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import nativeapp.android.apidemos.NotifyPage;
import nativeapp_android.NotificationTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static nativeapp.android.apidemos.NotifyPage.notification;
import static nativeapp.android.apidemos.app.StatusBarPage.*;

public class NotificationTests extends NotificationTestInit {

    @BeforeMethod
    public void initSteps() {
        new NotifyPage().sendSMS("333-45-45", "Hello From Tests");
        AndroidScreen.openNotificationPanel();

    }

    @Test
    public void headerInformationTest() {
        notificationPanel.is().displayed();
        new SoftAssert().assertEquals(notification.appConversationName(), "Messages");
        new SoftAssert().assertEquals(notification.notificationConversationName(), "333-4545");
        new SoftAssert().assertEquals(notification.time(), "now");
//         notification.isHeaderIconDisplayed();
//        softAssert.assertAll();
        System.out.println("Notification header text = " + notification.headerText());
    }

    @Test
    public void contentInformationTest() {
        notificationPanel.is().displayed();
        new SoftAssert().assertEquals(notification.notificationConversationName(),"333-4545");
        new SoftAssert().assertEquals(notification.contentText(), "Hello From Tests");
        new SoftAssert().assertEquals(notification.isLargeIconDisplayed(), true);
        new SoftAssert().assertAll();
    }

    @Test
    public void actionsMarkAsReadTest() {
        notificationPanel.is().displayed();
        NotificationActions.markAsRead.tap();
    }

    @Test
    public void actionsReplyTest() {
        notificationPanel.is().displayed();
        NotificationActions.reply.tap();
        MobileKeyboard.pressKey(new KeyEvent(AndroidKey.A));
        NotificationActions.send.tap();
        new SoftAssert().assertEquals(notification.notificationConversationName(),"333-4545");

        //check reply text
    }




    @AfterMethod
    public void afterMethodCloseStatusBar() {
        if (clearAllButton.isDisplayed()) clearAllButton.click();
        AndroidScreen.closeNotificationPanel();
    }
}
