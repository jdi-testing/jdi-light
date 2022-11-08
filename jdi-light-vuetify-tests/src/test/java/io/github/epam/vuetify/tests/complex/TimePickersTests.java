package io.github.epam.vuetify.tests.complex;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.timePickersPage;
import static io.github.com.pages.TimePickersPage.allowedTimesTimePicker;
import static io.github.com.pages.TimePickersPage.amPmInTitleTimePicker;
import static io.github.com.pages.TimePickersPage.disabledTimePicker;
import static io.github.com.pages.TimePickersPage.elevatedTimePicker;
import static io.github.com.pages.TimePickersPage.endEventTimePicker;
import static io.github.com.pages.TimePickersPage.firstColorTimePicker;
import static io.github.com.pages.TimePickersPage.firstWidthTimePicker;
import static io.github.com.pages.TimePickersPage.formatTimePicker;
import static io.github.com.pages.TimePickersPage.noTitleTimePicker;
import static io.github.com.pages.TimePickersPage.pickerInDialogTimePicker;
import static io.github.com.pages.TimePickersPage.pickerInMenuTimePicker;
import static io.github.com.pages.TimePickersPage.readOnlyTimePicker;
import static io.github.com.pages.TimePickersPage.secondAmPmInTitleTimePicker;
import static io.github.com.pages.TimePickersPage.secondColorTimePicker;
import static io.github.com.pages.TimePickersPage.startEventTimePicker;
import static io.github.com.pages.TimePickersPage.useSecondsTimePicker;

public class TimePickersTests extends TestsInit {

    private static final String GREEN_COLOR_HEX = "#66bb6a";
    private static final String BLUE_COLOR_HEX = "#1976d2";
    private static final String ELEVATION = "15px";
    private static final int TIME_PICKER_WIDTH = 290;

    private static final String CHOSEN_AVAILABLE_HOURS = "15";
    private static final String CHOSEN_TIME = "7:15:45 PM";
    private static final String CHOSEN_TIME_AM = "7:15 AM";
    private static final String CHOSEN_TIME_TWO_DIGITS = "07:15";
    private static final String CHOSEN_HOURS = "7";
    private static final String CHOSEN_MINUTES = "15";
    private static final String CHOSEN_SECONDS = "45";
    private static final String CHOSEN_HOURS_TWO = "7";
    private static final String CHOSEN_MINUTES_TWO = "15";
    private static final String CHOSEN_HOURS_THREE = "5";
    private static final String CHOSEN_MINUTES_THREE = "25";
    private static final String CHOSEN_HOURS_FOUR = "3";
    private static final String CHOSEN_MINUTES_FOUR = "55";
    private static final String CHOSEN_TIME_FOUR = "3:55 PM";
    private static final String CHOSEN_HOURS_FOUR_FORMATTED = "15";
    private static final String CHOSEN_TIME_FOUR_FORMATTED = "15:55";

    private static final List<String> CHECKED_ENABLED_HOURS = Arrays.asList("9", "11", "13", "15", "17", "19", "21");
    private static final List<String> CHECKED_DISABLED_HOURS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7",
            "8", "10", "12", "14", "16", "18", "20", "22", "23");
    private static final List<String> CHECKED_ENABLED_MINUTES = Arrays.asList("10", "15", "20", "25", "30", "35",
            "40", "45", "50");
    private static final List<String> CHECKED_DISABLED_MINUTES = Arrays.asList("00", "05", "55");

    private static final List<String> ALL_ENABLED_HOURS = Arrays.asList("12", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11");
    private static final List<String> ALL_ENABLED_MINUTES = Arrays.asList("00", "05", "10", "15", "20",
            "25", "30", "35", "40", "45", "50", "55");
    private static final List<String> END_EVENT_DISABLED_HOURS = Arrays.asList("12", "1", "2", "3", "4", "5", "6");
    private static final List<String> END_EVENT_DISABLED_MINUTES = Arrays.asList("00", "05", "10");

    @BeforeClass
    public void before() {
        timePickersPage.open();
        waitCondition(() -> timePickersPage.isOpened());
        timePickersPage.checkOpened();
    }

    @Test
    public void allowedTimesTimePickerTest() {
        Timer.waitCondition(() -> allowedTimesTimePicker.isVisible());
        allowedTimesTimePicker.has().twentyFourHourFormat();
        allowedTimesTimePicker.has().disabledHoursOrMinutesNonEmptyList();
        allowedTimesTimePicker.has().clickableEnabledHoursOrMinutes();
        allowedTimesTimePicker.has().nonClickableDisabledHoursOrMinutes();
        allowedTimesTimePicker.has().properEnabledHoursOrMinutes(CHECKED_ENABLED_HOURS);
        allowedTimesTimePicker.has().properDisabledHoursOrMinutes(CHECKED_DISABLED_HOURS);
        allowedTimesTimePicker.selectHours(CHOSEN_AVAILABLE_HOURS);
        allowedTimesTimePicker.has().properEnabledHoursOrMinutes(CHECKED_ENABLED_MINUTES);
        allowedTimesTimePicker.has().properDisabledHoursOrMinutes(CHECKED_DISABLED_MINUTES);
    }

    @Test
    public void amPmInTitleTimePickerTest() {
        Timer.waitCondition(() -> amPmInTitleTimePicker.isVisible());
        amPmInTitleTimePicker.switchToPM();
        amPmInTitleTimePicker.has().pmPeriod();
        amPmInTitleTimePicker.switchToAM();
        amPmInTitleTimePicker.has().amPeriod();
        secondAmPmInTitleTimePicker.switchToAM();
        secondAmPmInTitleTimePicker.has().amPeriod();
        secondAmPmInTitleTimePicker.switchToPM();
        secondAmPmInTitleTimePicker.has().pmPeriod();
    }

    @Test
    public void colorTimePickerTest() {
        Timer.waitCondition(() -> firstColorTimePicker.isVisible());
        firstColorTimePicker.has().twelveHourFormat();
        firstColorTimePicker.selectHours(CHOSEN_HOURS);
        firstColorTimePicker.selectMinutes(CHOSEN_MINUTES);
        firstColorTimePicker.has().hours(CHOSEN_HOURS);
        firstColorTimePicker.has().minutes(CHOSEN_MINUTES);
        firstColorTimePicker.has().amPeriod();
        firstColorTimePicker.switchToPM();
        firstColorTimePicker.has().pmPeriod();
        firstColorTimePicker.switchToAM();
        firstColorTimePicker.has().amPeriod();
        firstColorTimePicker.has().color(GREEN_COLOR_HEX);
        secondColorTimePicker.has().color(BLUE_COLOR_HEX);
    }

    @Test
    public void disabledTimePickerTest() {
        Timer.waitCondition(() -> disabledTimePicker.isVisible());
        disabledTimePicker.is().disabled();
        disabledTimePicker.has().activeHoursOrMinutes("12");
    }

    @Test
    public void elevationTimePickerTest() {
        Timer.waitCondition(() -> elevatedTimePicker.isVisible());
        elevatedTimePicker.has().elevation(ELEVATION);
    }

    @Test
    public void formatTimePickerTest() {
        Timer.waitCondition(() -> formatTimePicker.isVisible());
        formatTimePicker.has().twentyFourHourFormat();
        formatTimePicker.selectHours(CHOSEN_HOURS);
        formatTimePicker.selectMinutes(CHOSEN_MINUTES);
    }

    @Test
    public void noTitleTimePickerTest() {
        Timer.waitCondition(() -> noTitleTimePicker.isVisible());
        noTitleTimePicker.has().noTitle();
    }

    @Test
    public void planEventTimePickerTest() {
        Timer.waitCondition(() -> startEventTimePicker.isVisible());
        startEventTimePicker.switchToAM();
        startEventTimePicker.selectHours(CHOSEN_HOURS);
        startEventTimePicker.selectMinutes(CHOSEN_MINUTES);
        startEventTimePicker.has().hours(CHOSEN_HOURS);
        startEventTimePicker.has().minutes(CHOSEN_MINUTES);
        endEventTimePicker.has().properDisabledHoursOrMinutes(END_EVENT_DISABLED_HOURS);
        endEventTimePicker.selectHours(CHOSEN_HOURS_TWO);
        endEventTimePicker.has().properDisabledHoursOrMinutes(END_EVENT_DISABLED_MINUTES);
        endEventTimePicker.selectMinutes(CHOSEN_MINUTES_TWO);
        endEventTimePicker.has().hours(CHOSEN_HOURS_TWO);
        endEventTimePicker.has().minutes(CHOSEN_MINUTES_TWO);
        startEventTimePicker.selectHours(CHOSEN_HOURS_THREE);
        startEventTimePicker.selectMinutes(CHOSEN_MINUTES_THREE);
        startEventTimePicker.has().hours(CHOSEN_HOURS_THREE);
        startEventTimePicker.has().minutes(CHOSEN_MINUTES_THREE);
        endEventTimePicker.switchToPM();
        endEventTimePicker.clickTitleHours();
        endEventTimePicker.has().properEnabledHoursOrMinutes(ALL_ENABLED_HOURS);
        endEventTimePicker.selectHours(CHOSEN_HOURS_FOUR);
        endEventTimePicker.has().properEnabledHoursOrMinutes(ALL_ENABLED_MINUTES);
        endEventTimePicker.selectMinutes(CHOSEN_MINUTES_FOUR);
        endEventTimePicker.has().hours(CHOSEN_HOURS_FOUR);
        endEventTimePicker.has().minutes(CHOSEN_MINUTES_FOUR);
    }

    @Test
    public void readOnlyTimePickerTest() {
        readOnlyTimePicker.selectHours(CHOSEN_HOURS);
        readOnlyTimePicker.has().nonActiveHoursOrMinutes(CHOSEN_HOURS);
        readOnlyTimePicker.selectMinutes(CHOSEN_MINUTES);
        readOnlyTimePicker.has().nonActiveHoursOrMinutes(CHOSEN_MINUTES);
    }

    @Test
    public void useSecondsTimePickerTest() {
        Timer.waitCondition(() -> useSecondsTimePicker.isVisible());
        useSecondsTimePicker.selectTime(CHOSEN_TIME);
        useSecondsTimePicker.has().hours(CHOSEN_HOURS);
        useSecondsTimePicker.has().minutes(CHOSEN_MINUTES);
        useSecondsTimePicker.has().seconds(CHOSEN_SECONDS);
        useSecondsTimePicker.has().time(CHOSEN_TIME);
    }

    @Test
    public void widthTimePickerTest() {
        Timer.waitCondition(() -> firstWidthTimePicker.isVisible());
        firstWidthTimePicker.has().pickerWidth(TIME_PICKER_WIDTH);
    }

    @Test
    public void menuTimePickerTest() {
        Timer.waitCondition(() -> pickerInMenuTimePicker.isVisible());
        pickerInMenuTimePicker.expand();
        pickerInMenuTimePicker.switchToAM();
        pickerInMenuTimePicker.selectHours(CHOSEN_HOURS);
        pickerInMenuTimePicker.has().hours(CHOSEN_HOURS);
        pickerInMenuTimePicker.selectMinutes(CHOSEN_MINUTES);
        pickerInDialogTimePicker.has().resultTime(CHOSEN_TIME_TWO_DIGITS);
    }

    @Test
    public void dialogTimePickerTest() {
        Timer.waitCondition(() -> pickerInDialogTimePicker.isVisible());
        pickerInDialogTimePicker.expand();
        pickerInDialogTimePicker.clickCancel();
        pickerInDialogTimePicker.expand();
        pickerInDialogTimePicker.selectHours(CHOSEN_HOURS);
        pickerInDialogTimePicker.has().hours(CHOSEN_HOURS);
        pickerInDialogTimePicker.selectMinutes(CHOSEN_MINUTES);
        pickerInDialogTimePicker.has().minutes(CHOSEN_MINUTES);
        pickerInDialogTimePicker.has().time(CHOSEN_TIME_AM);
        pickerInDialogTimePicker.has().localTime(LocalTime.of(
                Integer.parseInt(CHOSEN_HOURS), Integer.parseInt(CHOSEN_MINUTES)));
        pickerInDialogTimePicker.clickOk();
        pickerInDialogTimePicker.has().resultTime(CHOSEN_TIME_TWO_DIGITS);
        pickerInDialogTimePicker.has().resultLocalTime(LocalTime.of(
                Integer.parseInt(CHOSEN_HOURS), Integer.parseInt(CHOSEN_MINUTES)));
        pickerInDialogTimePicker.expand();
        pickerInDialogTimePicker.switchToPM();
        pickerInDialogTimePicker.selectHours(CHOSEN_HOURS_FOUR);
        pickerInDialogTimePicker.selectMinutes(CHOSEN_MINUTES_FOUR);
        pickerInDialogTimePicker.has().time(CHOSEN_TIME_FOUR);
        pickerInDialogTimePicker.has().localTime(LocalTime.of(
                Integer.parseInt(CHOSEN_HOURS_FOUR_FORMATTED), Integer.parseInt(CHOSEN_MINUTES_FOUR)));
        pickerInDialogTimePicker.clickOk();
        pickerInDialogTimePicker.has().resultTime(CHOSEN_TIME_FOUR_FORMATTED);
        pickerInDialogTimePicker.has().resultLocalTime(
                LocalTime.of(Integer.parseInt(CHOSEN_HOURS_FOUR_FORMATTED), Integer.parseInt(CHOSEN_MINUTES_FOUR)));
    }
}
