package nativeapp_android.tests;

import nativeapp_android.ClockAppTestsInit;
import org.testng.annotations.Test;

import static nativeapp.android.AlarmPage.*;

public class AlarmAppTests extends ClockAppTestsInit {
    @Test
    public void checkboxTests() {
        alarmPageButton.click();
        expandAlarmSettingsButton.click();

        repeatAlarmCheckbox.is().displayed();
        repeatAlarmCheckbox.is().selected();
        repeatDaysAlarmWidget.is().displayed();

        repeatAlarmCheckbox.uncheck();
        repeatAlarmCheckbox.is().deselected();
        repeatDaysAlarmWidget.is().hidden();

        manageVibrationCheckbox.check();
        manageVibrationCheckbox.is().selected();

        manageVibrationCheckbox.uncheck();
        manageVibrationCheckbox.is().deselected();

        manageVibrationCheckbox.check();
        manageVibrationCheckbox.is().selected();
    }
}
