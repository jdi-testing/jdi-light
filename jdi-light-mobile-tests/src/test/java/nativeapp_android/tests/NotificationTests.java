package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.app.android.notification.NotificationActions;
import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;

import nativeapp.android.apidemos.NotifyPage;
import nativeapp_android.NotificationTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static nativeapp.android.apidemos.NotifyPage.notification;
import static nativeapp.android.apidemos.app.StatusBarPage.clearAllButton;
import static nativeapp.android.apidemos.app.StatusBarPage.notificationPanel;

public class NotificationTests extends NotificationTestInit {

    @BeforeMethod
    public void initSteps() {
        new NotifyPage().sendSMS("333-45-45", "Hello From Tests");
        AndroidScreen.openNotificationPanel();
    }

    @Test
    public void headerInformationTest() {
        notificationPanel.is().displayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(notification.appName(), "Messages");
        softAssert.assertEquals(notification.time(), "now");
//         notification.isHeaderIconDisplayed();
//        softAssert.assertAll();
        System.out.println("Notification header text = " + notification.headerText());
    }

    @Test
    public void contentInformationTest() {
        notificationPanel.is().displayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(notification.title(), "333-4545");
        softAssert.assertEquals(notification.contentText(), "What a wonderful world");
        softAssert.assertEquals(notification.isLargeIconDisplayed(), true);
        softAssert.assertAll();
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
        NotificationActions.replyInput.sendKeys("Hello From Tester");
        NotificationActions.send.tap();

    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        if (clearAllButton.isDisplayed()) clearAllButton.click();
        AndroidScreen.closeNotificationPanel();
    }
}
