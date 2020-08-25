package nativeapp_android.tests;

import nativeapp_android.ClockAppTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.Alarm.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AlarmTest extends ClockAppTestInit {
    @Test
    public void checkboxTests() {
        alarmPageButton.click();
        expandAlarmSettingsButton.click();
        assertTrue(repeatAlarmCheckbox.isDisplayed());
        assertTrue(repeatAlarmCheckbox.isChecked());
        assertTrue(repeatDaysAlarmWidget.isDisplayed());
        repeatAlarmCheckbox.uncheck();
        assertFalse(repeatAlarmCheckbox.isChecked());
        assertFalse(repeatDaysAlarmWidget.isDisplayed());
        manageVibrationCheckbox.check();
        assertTrue(manageVibrationCheckbox.isChecked());
        manageVibrationCheckbox.uncheck();
        assertFalse(manageVibrationCheckbox.isChecked());
        manageVibrationCheckbox.check();
        assertTrue(manageVibrationCheckbox.isChecked());
    }
}
