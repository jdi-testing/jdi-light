package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp.android.NotifyPage;
import nativeapp_android.NotificationTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static nativeapp.android.NotifyPage.clearAllButton;
import static nativeapp.android.NotifyPage.notification;
import static nativeapp.android.apidemos.app.StatusBarPage.notificationPanel;

public class NotificationTests extends NotificationTestInit {

    @BeforeMethod
    public void initSteps() {

    }

    @Test
    public void headerInformationTest() {
        new NotifyPage().sendSMS("333-45-45", "Hello From Tests");

        AndroidScreen.openNotificationPanel();
        notificationPanel.is().displayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(notification.appName(), "Messages");
        softAssert.assertEquals(notification.time(), "now");
        //softAssert.assertEquals(notification.isHeaderIconDisplayed(), true);
        softAssert.assertAll();
//        System.out.println("Notification header text = " + notification.headerText());
    }

    @Test
    public void ContentInformationTest() {
        new NotifyPage().sendSMS("333-4545", "What a wonderful world");

        AndroidScreen.openNotificationPanel();
        notificationPanel.is().displayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(notification.title(), "333-4545");
        softAssert.assertEquals(notification.contentText(), "What a wonderful world");
        softAssert.assertEquals(notification.isLargeIconDisplayed(), true);
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        clearAllButton.click();
        AndroidScreen.closeNotificationPanel();
    }
}
