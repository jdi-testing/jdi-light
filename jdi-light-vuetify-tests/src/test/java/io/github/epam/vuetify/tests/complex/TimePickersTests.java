package io.github.epam.vuetify.tests.complex;

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
import static io.github.com.pages.TimePickersPage.firstColorTimePicker;
import static io.github.com.pages.TimePickersPage.firstWidthTimePicker;
import static io.github.com.pages.TimePickersPage.formatTimePicker;
import static io.github.com.pages.TimePickersPage.noTitleTimePicker;
import static io.github.com.pages.TimePickersPage.pickerInDialogTimePicker;
import static io.github.com.pages.TimePickersPage.readOnlyTimePicker;
import static io.github.com.pages.TimePickersPage.scrollableTimePicker;
import static io.github.com.pages.TimePickersPage.secondAmPmInTitleTimePicker;
import static io.github.com.pages.TimePickersPage.useSecondsTimePicker1;
import static io.github.com.pages.TimePickersPage.useSecondsTimePicker2;

public class TimePickersTests extends TestsInit {

    private static final String GREEN_COLOR_HEX = "#66bb6a";
    private static final int ELEVATION = 15;
    private static final int TIME_PICKER_WIDTH = 290;
    private static final int TIME_PICKER_HEIGHT = 392;
    private static final String CHOSEN_TIME = "7:15:45 PM";
    private static final String CHOSEN_TIME_AM = "7:15 AM";
    private static final String CHOSEN_TIME_TWO_DIGITS = "07:15";
    private static final int CHOSEN_HOURS = 7;
    private static final int CHOSEN_MINUTES = 15;
    private static final int CHOSEN_SECONDS = 45;
    private static final int CHOSEN_HOURS_FOUR = 3;
    private static final int CHOSEN_MINUTES_FOUR = 55;
    private static final String CHOSEN_TIME_FOUR = "3:55 PM";
    private static final int CHOSEN_HOURS_FOUR_FORMATTED = 15;
    private static final String CHOSEN_TIME_FOUR_FORMATTED = "15:55";
    private static final int SCROLL_TICS = 3;
    private static final String CHOSEN_TIME_SCROLLED = "10:12 AM";
    private static final List<String> CHECKED_ENABLED_HOURS = Arrays.asList("9", "11", "13", "15", "17", "19", "21");
    private static final List<String> CHECKED_DISABLED_HOURS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7",
            "8", "10", "12", "14", "16", "18", "20", "22", "23");

    @BeforeClass
    public void before() {
        timePickersPage.open();
        waitCondition(() -> timePickersPage.isOpened());
        timePickersPage.checkOpened();
    }

    @Test(description = "Test checks that enabled and disabled hours or minutes are proper")
    public void allowedTimesTimePickerTest() {
        allowedTimesTimePicker.show();
        allowedTimesTimePicker.has().disabledHoursOrMinutesNonEmptyList();
        allowedTimesTimePicker.has().clickableEnabledHoursOrMinutes();
        allowedTimesTimePicker.has().nonClickableDisabledHoursOrMinutes();
        allowedTimesTimePicker.has().properEnabledHoursOrMinutes(CHECKED_ENABLED_HOURS);
        allowedTimesTimePicker.has().properDisabledHoursOrMinutes(CHECKED_DISABLED_HOURS);
        allowedTimesTimePicker.has().activeHoursOrMinutes("11");
        allowedTimesTimePicker.has().nonActiveHoursOrMinutes("0");
    }

    @Test (description = "Test checks switching to AM/PM periods : am/pm in title")
    public void amPmInTitleTimePickerTest() {
        amPmInTitleTimePicker.show();
        amPmInTitleTimePicker.switchToPM();
        amPmInTitleTimePicker.has().pmPeriod();
        amPmInTitleTimePicker.switchToAM();
        amPmInTitleTimePicker.has().amPeriod();
        secondAmPmInTitleTimePicker.switchToAM();
        secondAmPmInTitleTimePicker.has().amPeriod();
        secondAmPmInTitleTimePicker.switchToPM();
        secondAmPmInTitleTimePicker.has().pmPeriod();
    }

    @Test (description = "Test checks element's background color")
    public void colorTimePickerTest() {
        firstColorTimePicker.show();
        firstColorTimePicker.has().backgroundColor(GREEN_COLOR_HEX);
    }

    @Test (description = "Test checks that timepicker is disabled or not")
    public void disabledTimePickerTest() {
        disabledTimePicker.show();
        disabledTimePicker.is().disabled();
        elevatedTimePicker.show();
        elevatedTimePicker.is().enabled();
    }

    @Test (description = "Test checks that element has elevation or not")
    public void elevationTimePickerTest() {
        elevatedTimePicker.show();
        elevatedTimePicker.is().elevated();
        elevatedTimePicker.has().elevation(ELEVATION);
    }

    @Test (description = "Test checks that AM/PM, hours, minutes, seconds can be selected correctly")
    public void selectHoursMinutesSecondsTimePickerTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.switchToPM();
        useSecondsTimePicker1.selectHours(CHOSEN_HOURS);
        useSecondsTimePicker1.selectMinutes(CHOSEN_MINUTES);
        useSecondsTimePicker1.selectSeconds(CHOSEN_SECONDS);
        useSecondsTimePicker1.has().hours(CHOSEN_HOURS);
        useSecondsTimePicker1.has().minutes(CHOSEN_MINUTES);
        useSecondsTimePicker1.has().seconds(CHOSEN_SECONDS);
        useSecondsTimePicker1.has().time(CHOSEN_TIME);
    }

    @Test (description = "Test selects time and checks that it is selected")
    public void setTimeWithSecondsTimePickerTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.selectTime(CHOSEN_TIME);
        useSecondsTimePicker1.has().time(CHOSEN_TIME);
    }

    @Test (description = "Test checks if timepicker has title or not")
    public void titleTimePickerTest() {
        noTitleTimePicker.show();
        noTitleTimePicker.has().noTitle();
        formatTimePicker.show();
        formatTimePicker.has().title();
    }

    @Test (description = "Test checks if timepicker is readonly or not : readonly")
    public void readOnlyTimePickerTest() {
        readOnlyTimePicker.show();
        readOnlyTimePicker.is().readonly();
        scrollableTimePicker.show();
        scrollableTimePicker.is().notReadonly();
    }

    @Test (description = "Test checks theme of timepicker : theme (dark/light)")
    public void themeTimePickerTest() {
        scrollableTimePicker.show();
        scrollableTimePicker.has().darkTheme();
        readOnlyTimePicker.show();
        readOnlyTimePicker.has().lightTheme();
    }

    @Test (description = "Test checks that timepicker is landscape or not : title position")
    public void landscapeTimePickerTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.is().notLandscape();
        useSecondsTimePicker2.show();
        useSecondsTimePicker2.is().landscape();
    }

    @Test (description = "Test checks timepicker's measurements")
    public void widthTimePickerTest() {
        firstWidthTimePicker.show();
        firstWidthTimePicker.has().width(TIME_PICKER_WIDTH);
        firstWidthTimePicker.has().height(TIME_PICKER_HEIGHT);
    }

    @Test (description = "Test checks time changes in dialog timepicker")
    public void dialogTimePickerTest() {
        pickerInDialogTimePicker.show();
        pickerInDialogTimePicker.expand();
        pickerInDialogTimePicker.clickCancel();
        pickerInDialogTimePicker.expand();
        pickerInDialogTimePicker.selectHours(CHOSEN_HOURS);
        pickerInDialogTimePicker.has().hours(CHOSEN_HOURS);
        pickerInDialogTimePicker.selectMinutes(CHOSEN_MINUTES);
        pickerInDialogTimePicker.has().minutes(CHOSEN_MINUTES);
        pickerInDialogTimePicker.has().time(CHOSEN_TIME_AM);
        pickerInDialogTimePicker.has().localTime(LocalTime.of(CHOSEN_HOURS, CHOSEN_MINUTES));
        pickerInDialogTimePicker.clickOk();
        pickerInDialogTimePicker.has().resultTime(CHOSEN_TIME_TWO_DIGITS);
        pickerInDialogTimePicker.has().resultLocalTime(LocalTime.of(CHOSEN_HOURS, CHOSEN_MINUTES));
        pickerInDialogTimePicker.expand();
        pickerInDialogTimePicker.switchToPM();
        pickerInDialogTimePicker.selectHours(CHOSEN_HOURS_FOUR);
        pickerInDialogTimePicker.selectMinutes(CHOSEN_MINUTES_FOUR);
        pickerInDialogTimePicker.has().time(CHOSEN_TIME_FOUR);
        pickerInDialogTimePicker.has().localTime(LocalTime.of(CHOSEN_HOURS_FOUR_FORMATTED, CHOSEN_MINUTES_FOUR));
        pickerInDialogTimePicker.clickOk();
        pickerInDialogTimePicker.has().resultTime(CHOSEN_TIME_FOUR_FORMATTED);
        pickerInDialogTimePicker.has().resultLocalTime(LocalTime.of(CHOSEN_HOURS_FOUR_FORMATTED, CHOSEN_MINUTES_FOUR));
    }

    @Test (description = "Test checks time changes on mouse wheel scroll event")
    public void scrollTimePickerTest() {
        scrollableTimePicker.show();
        scrollableTimePicker.selectHours(CHOSEN_HOURS);
        scrollableTimePicker.selectMinutes(CHOSEN_MINUTES);
        scrollableTimePicker.clickTitleHours();
        scrollableTimePicker.scrollOnClock(-SCROLL_TICS);
        scrollableTimePicker.has().hours(CHOSEN_HOURS + SCROLL_TICS);
        scrollableTimePicker.clickTitleMinutes();
        scrollableTimePicker.scrollOnClock(SCROLL_TICS);
        scrollableTimePicker.has().minutes(CHOSEN_MINUTES - SCROLL_TICS);
        scrollableTimePicker.has().time(CHOSEN_TIME_SCROLLED);
    }
}
