package nativeapp_android.tests;

import nativeapp.android.PermissionManager;
import nativeapp_android.PermissionManagerTestInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PermissionManagerTest extends PermissionManagerTestInit {

    @Test
    public void radioButtonTest() {
        PermissionManager.appsAndNotificationsButton.click();
        PermissionManager.advanceSettingsButton.click();
        PermissionManager.permissionManagerButton.click();
        PermissionManager.calendarButton.click();
        PermissionManager.calendarAppPermissionButton.click();
        PermissionManager.permissionRadioGroup.select("Deny");
        PermissionManager.confirmButton.click();
       // assertEquals(PermissionManager.permissionRadioGroup.select("Deny").isEnabled(), true);
        //assertEquals(PermissionManager.permissionRadioGroup.isDisabled(), false);
    }
}
