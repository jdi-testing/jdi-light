package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import java.io.IOException;
import java.time.LocalTime;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.timePickersPage;
import static io.github.com.pages.TimePickersPage.allowedTimesTimePicker;
import static io.github.com.pages.TimePickersPage.amPmInTitleTimePicker;
import static io.github.com.pages.TimePickersPage.dialogForTimePicker;
import static io.github.com.pages.TimePickersPage.disabledTimePicker;
import static io.github.com.pages.TimePickersPage.elevatedTimePicker;
import static io.github.com.pages.TimePickersPage.firstColorTimePicker;
import static io.github.com.pages.TimePickersPage.firstWidthTimePicker;
import static io.github.com.pages.TimePickersPage.formatTimePicker;
import static io.github.com.pages.TimePickersPage.inputForDialogTimePicker;
import static io.github.com.pages.TimePickersPage.inputForMenuTimePicker;
import static io.github.com.pages.TimePickersPage.menuForTimePicker;
import static io.github.com.pages.TimePickersPage.noTitleTimePicker;
import static io.github.com.pages.TimePickersPage.readOnlyTimePicker;
import static io.github.com.pages.TimePickersPage.scrollableTimePicker;
import static io.github.com.pages.TimePickersPage.secondAmPmInTitleTimePicker;
import static io.github.com.pages.TimePickersPage.timePickerInDialog;
import static io.github.com.pages.TimePickersPage.timePickerInMenu;
import static io.github.com.pages.TimePickersPage.useSecondsTimePicker1;
import static io.github.com.pages.TimePickersPage.useSecondsTimePicker2;
import static io.github.com.pages.TimePickersPage.verticalNoTitleTimePicker;


public class TimePickersTests extends TestsInit {

    private static final String GREEN_COLOR_HEX = "#66bb6a";
    private static final int ELEVATION = 15;
    private static final int TIME_PICKER_WIDTH = 290;
    private static final int TIME_PICKER_HEIGHT = 392;
    private static final int SEVEN = 7;
    private static final int FIFTEEN = 15;
    private static final int NINETEEN = 19;
    private static final int FORTY_FIVE = 45;
    private static final int FIFTY_NINE = 59;
    private static final String SEVEN_FIFTY_AM = "7:15AM";
    private static final String SEVEN_FIFTY_24H = "07:15";
    private static final String NINETEEN_FIFTY_24H = "19:15";
    private static final String SEVEN_FIFTY_FORTY_FIVE_PM = "7:15:45PM";
    private static final String SEVEN_FIFTY_FORTY_FIVE_24H = "07:15:45";
    private static final String EIGHT_NINE_24H = "08:09";
    private static final String TWENTY_THREE_SEVENTEEN_FIFTY_NINE = "23:17:59";
    private static final String UNSET_TIME_AM = "--:--AM";
    private static final Integer[] ENABLED_HOURS = {9, 11, 13, 15, 17, 19, 21};
    private static final Integer[] DISABLED_HOURS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16, 18, 20, 22, 23};

    @BeforeClass
    public void before() {
        timePickersPage.open();
        waitCondition(() -> timePickersPage.isOpened());
        timePickersPage.checkOpened();
    }

    @Test(description = "Test checks that enabled and disabled hours or minutes are proper")
    public void allowedTimesTimePickerTest() {
        allowedTimesTimePicker.show();
        allowedTimesTimePicker.switchToHours();
        allowedTimesTimePicker.has().enabledNumbers(ENABLED_HOURS);
        allowedTimesTimePicker.has().disabledNumbers(DISABLED_HOURS);
        allowedTimesTimePicker.has().selectedNumber(11);
    }

    @Test(
        description = "Test it is impossible to select disabled time",
        expectedExceptions = ElementClickInterceptedException.class)
    public void notAllowedTimesTimePickerTest() {
        allowedTimesTimePicker.show();
        allowedTimesTimePicker.setTime(EIGHT_NINE_24H);
    }

    @Test(description = "Test checks switching to AM/PM periods : am/pm in title")
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

    @Test(description = "Test checks element's background color")
    public void colorTimePickerTest() {
        firstColorTimePicker.show();
        firstColorTimePicker.has().backgroundColor(GREEN_COLOR_HEX);
    }

    @Test(description = "Test checks that timepicker is disabled or not")
    public void disabledTimePickerTest() {
        disabledTimePicker.show();
        disabledTimePicker.is().disabled();
        elevatedTimePicker.show();
        elevatedTimePicker.is().enabled();
    }

    @Test(description = "Test checks that element has elevation or not")
    public void elevationTimePickerTest() {
        elevatedTimePicker.show();
        elevatedTimePicker.is().elevated();
        elevatedTimePicker.has().elevation(ELEVATION);
    }

    @Test(description = "Test checks that AM/PM, hours, minutes, seconds can be selected correctly")
    public void selectHoursMinutesSecondsTimePickerTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.switchToPM();
        useSecondsTimePicker1.setHours(SEVEN);
        useSecondsTimePicker1.setMinutes(FIFTEEN);
        useSecondsTimePicker1.setSeconds(FORTY_FIVE);
        useSecondsTimePicker1.has().hours(SEVEN);
        useSecondsTimePicker1.has().minutes(FIFTEEN);
        useSecondsTimePicker1.has().seconds(FORTY_FIVE);
        useSecondsTimePicker1.has().title(SEVEN_FIFTY_FORTY_FIVE_PM);
    }

    @Test(description = "Test selects time and checks that it is selected")
    public void setTimeWithSecondsTimePickerTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.setTime(LocalTime.parse(SEVEN_FIFTY_FORTY_FIVE_24H));
        useSecondsTimePicker1.switchToPM();
        useSecondsTimePicker1.has().title(SEVEN_FIFTY_FORTY_FIVE_PM);
    }

    @Test(description = "Test checks that it is possible to set time on timepicker without title")
    //TODO Use menu/dialog timepicker without title to get rid of sleep & perform set time check on input
    public void titleTimePickerTest() {
        noTitleTimePicker.show();
        noTitleTimePicker.title.isHidden();
        noTitleTimePicker.has().amPeriod();
        noTitleTimePicker.switchToPM();
        noTitleTimePicker.has().pmPeriod();
        noTitleTimePicker.select(SEVEN);
        noTitleTimePicker.select(FIFTY_NINE);
        verticalNoTitleTimePicker.has().selectedNumber(SEVEN);
        noTitleTimePicker.has().selectedNumber(FIFTY_NINE);
    }

    @Test(description = "Test checks if timepicker is readonly or not readonly")
    public void readOnlyTimePickerTest() {
        readOnlyTimePicker.show();
        readOnlyTimePicker.is().readonly();
        scrollableTimePicker.show();
        scrollableTimePicker.is().notReadonly();
    }

    @Test(description = "Test checks theme of timepicker : theme (dark/light)")
    public void themeTimePickerTest() {
        scrollableTimePicker.show();
        scrollableTimePicker.has().darkTheme();
        readOnlyTimePicker.show();
        readOnlyTimePicker.has().lightTheme();
    }

    @Test(description = "Test checks that timepicker is landscape or not : title position")
    public void landscapeTimePickerTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.is().notLandscape();
        useSecondsTimePicker2.show();
        useSecondsTimePicker2.is().landscape();
    }

    @Test(description = "Test checks timepicker's measurements")
    public void widthTimePickerTest() {
        firstWidthTimePicker.show();
        firstWidthTimePicker.has().width(TIME_PICKER_WIDTH);
        firstWidthTimePicker.has().height(TIME_PICKER_HEIGHT);
    }

    @Test(description = "Test checks time changes in menu timepicker")
    public void menuTimePickerTest() {
        inputForMenuTimePicker.show();
        inputForMenuTimePicker.click();
        timePickerInMenu.show();
        menuForTimePicker.is().displayed();
        timePickerInMenu.is().displayed();
        menuForTimePicker.press(Keys.ESCAPE);
        timePickerInMenu.is().hidden();
        inputForMenuTimePicker.click();
        timePickerInMenu.show();
        timePickerInMenu.is().displayed();
        timePickerInMenu.setTime(SEVEN_FIFTY_24H);
        inputForMenuTimePicker.has().typedText(SEVEN_FIFTY_24H);
        inputForMenuTimePicker.click();
        inputForMenuTimePicker.has().typedText(SEVEN_FIFTY_24H);
    }

    @Test(description = "Test checks time changes in dialog timepicker")
    public void dialogTimePickerTest() {
        inputForDialogTimePicker.show();
        inputForDialogTimePicker.click();
        timePickerInDialog.is().displayed();
        timePickerInDialog.has().title(UNSET_TIME_AM);
        timePickerInDialog.setTime(SEVEN_FIFTY_24H);
        timePickerInDialog.has().title(SEVEN_FIFTY_AM);
        dialogForTimePicker.close("Cancel");
        inputForMenuTimePicker.is().empty();
        inputForDialogTimePicker.click();
        timePickerInDialog.has().title(UNSET_TIME_AM);
        timePickerInDialog.setTime(SEVEN_FIFTY_24H);
        timePickerInDialog.has().title(SEVEN_FIFTY_AM);
        timePickerInDialog.switchToPM();
        dialogForTimePicker.close("OK");
        inputForMenuTimePicker.has().typedText(NINETEEN_FIFTY_24H);
    }

    @Test(description = "Check that it is possible to set timepicker to numbers not present on the clock")
    public void selectNonPresentNumbersTest() {
        useSecondsTimePicker1.show();
        useSecondsTimePicker1.setTime(TWENTY_THREE_SEVENTEEN_FIFTY_NINE);
        useSecondsTimePicker1.has().time(LocalTime.parse(TWENTY_THREE_SEVENTEEN_FIFTY_NINE));
    }

    @Test(description = "Check that it is possible to set timepicker having 24h format")
    public void timepickerIn24hFormat() {
        formatTimePicker.show();
        formatTimePicker.setHours(NINETEEN);
        formatTimePicker.setMinutes(FIFTEEN);
        formatTimePicker.has().title(NINETEEN_FIFTY_24H);
    }

    @Test(description = "Test timepicker format")
    public void timepickerFormat() {
        disabledTimePicker.show();
        disabledTimePicker.has().format12();
        allowedTimesTimePicker.show();
        allowedTimesTimePicker.has().format24();
    }

    @Test(description = "Test timepicker theme")
    public void timepickerTheme() {
        scrollableTimePicker.show();
        scrollableTimePicker.has().darkTheme();
    }
}
