package nativeapp_android.tests;

import nativeapp.android.PermissionManager;
import nativeapp_android.PermissionManagerTestInit;
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
        PermissionManager.denyRadioButton.clickOnTheRadioButton();
        PermissionManager.confirmButton.click();
        assertEquals(PermissionManager.denyRadioButton.isRadioButtonSelected(), true);
        assertEquals(PermissionManager.allowRadioButton.isRadioButtonSelected(), false);
    }
}
