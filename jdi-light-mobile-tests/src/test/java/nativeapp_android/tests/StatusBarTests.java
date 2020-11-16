package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.*;


import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apiDemos.AppPage.*;
import static nativeapp.android.apiDemos.IndexPage.*;
import static nativeapp.android.apiDemos.NotificationPage.*;
import static nativeapp.android.apiDemos.StatusBarPage.*;

public class StatusBarTests extends ApiDemosTestInit {

    @BeforeClass
    public void beforeClass() {
        logger.toLog("Run StatusBarTests");
    }

    @BeforeMethod
    public void initSteps() {
        appPage.click();
        notificationPage.click();

        statusBarButton.click();
        happyButton.click();
    }

    @Test
    public void openNotificationTest() {

        AndroidScreen.openStatusBar();
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

        AndroidScreen.openStatusBar();
        notificationPanel.is().displayed();
        AndroidScreen.closeStatusBar();

        clearNotificationButton.click();
        AndroidScreen.openStatusBar();
        noNotifications.is().displayed();
    }

    @Test
    public void clearAllButtonTest(){

        AndroidScreen.openStatusBar();
        notificationPanel.is().displayed();
        clearAllButton.click();
        notificationPanel.waitFor().hidden();

        AndroidScreen.openStatusBar();
        noNotifications.is().displayed();
    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        AndroidScreen.closeStatusBar();
    }

}
