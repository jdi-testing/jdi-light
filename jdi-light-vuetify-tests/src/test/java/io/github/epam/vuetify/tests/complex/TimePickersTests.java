package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.timePickersPage;
import static io.github.com.pages.TimePickersPage.allowedTimesTimePicker;
import static io.github.com.pages.TimePickersPage.disabledTimePicker;
import static io.github.com.pages.TimePickersPage.readOnlyTimePicker;

public class TimePickersTests extends TestsInit {

    @BeforeClass
    public static void before() {
        timePickersPage.open();
        waitCondition(() -> timePickersPage.isOpened());
        timePickersPage.checkOpened();
    }

    @Test
    public static void allowedTimesTimePickerTest() {
        allowedTimesTimePicker.is().enabled();
        allowedTimesTimePicker.has().size(24);
        allowedTimesTimePicker.select("9");
        allowedTimesTimePicker.select("30");
        allowedTimesTimePicker.is().selected("30");
        allowedTimesTimePicker.has().values("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55");
        allowedTimesTimePicker.is().displayed();
        allowedTimesTimePicker.has().elementDisabled("55");
    }

    @Test
    public static void disabledTimePickerTest() {
        disabledTimePicker.is().disabled();
        disabledTimePicker.has().size(12);
        disabledTimePicker.is().selected("12");
    }

    @Test
    public static void readOnlyTimePickerTest() {
        readOnlyTimePicker.select(3);
        readOnlyTimePicker.has().selected("12");
        readOnlyTimePicker.has().size(12);
    }
}
