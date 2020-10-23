package nativeapp_android.tests;

import nativeapp_android.ClockAppTestsInit;
import org.testng.annotations.Test;

import static nativeapp.android.AlarmPage.*;
import static nativeapp.android.AlarmSettings.*;

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

    @Test
    public void seekbarTests() {
        alarMoreOptions.click();
        settingsButton.click();
        alarmVolume.setMaximumValue();
        alarmVolume.setMinimumValue();
        alarmVolume.setSliderValue("5");
    }
}