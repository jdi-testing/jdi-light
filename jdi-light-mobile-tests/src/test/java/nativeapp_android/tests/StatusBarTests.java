package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apidemos.app.AppPage.*;
import static nativeapp.android.apidemos.IndexPage.*;
import static nativeapp.android.apidemos.app.NotificationPage.*;
import static nativeapp.android.apidemos.app.StatusBarPage.*;

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
