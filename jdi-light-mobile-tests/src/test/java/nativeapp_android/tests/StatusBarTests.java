package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apidemos.IndexPage.appPage;
import static nativeapp.android.apidemos.app.AppPage.notificationPage;
import static nativeapp.android.apidemos.app.NotificationPage.clearNotificationButton;
import static nativeapp.android.apidemos.app.NotificationPage.happyButton;
import static nativeapp.android.apidemos.app.NotificationPage.happyIconButton;
import static nativeapp.android.apidemos.app.NotificationPage.statusBarButton;
import static nativeapp.android.apidemos.app.StatusBarPage.appName;
import static nativeapp.android.apidemos.app.StatusBarPage.title;
import static nativeapp.android.apidemos.app.StatusBarPage.appText;
import static nativeapp.android.apidemos.app.StatusBarPage.appIcon;
import static nativeapp.android.apidemos.app.StatusBarPage.clearAllButton;
import static nativeapp.android.apidemos.app.StatusBarPage.noNotifications;
import static nativeapp.android.apidemos.app.StatusBarPage.notificationPanel;
import static nativeapp.android.apidemos.app.StatusBarPage.statusBarLatestEventContent;

public class StatusBarTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        appPage.click();
        notificationPage.click();

        statusBarButton.click();
        happyButton.click();
    }

    @Test
    public void openNotificationTest() {

        AndroidScreen.openNotificationPanel();
        notificationPanel.is().displayed();
        appIcon.is().displayed();

        appName.is().text("API Demos");
        title.is().text("Mood ring");
        appText.is().text("I am happy");

        statusBarLatestEventContent.click();
        happyIconButton.is().displayed();
        happyIconButton.click();
    }

    @Test
    public void clearNotificationButtonTest(){

        AndroidScreen.openNotificationPanel();
        notificationPanel.is().displayed();
        AndroidScreen.closeNotificationPanel();

        clearNotificationButton.click();
        AndroidScreen.openNotificationPanel();
        noNotifications.is().displayed();
    }

    @Test
    public void clearAllButtonTest(){

        AndroidScreen.openNotificationPanel();
        notificationPanel.is().displayed();
        clearAllButton.click();
        notificationPanel.waitFor().hidden();

        AndroidScreen.openNotificationPanel();
        noNotifications.is().displayed();
    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        AndroidScreen.closeNotificationPanel();
    }

}
