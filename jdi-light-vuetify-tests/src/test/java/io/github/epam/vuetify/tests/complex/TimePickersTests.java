package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.timePickersPage;
import static io.github.com.pages.TimePickersPage.allowedTimesTimePicker;
import static io.github.com.pages.TimePickersPage.disabledTimePicker;
import static io.github.com.pages.TimePickersPage.readOnlyTimePicker;

public class TimePickersTests extends TestsInit {

    @BeforeClass
    public static void before() {
        timePickersPage.open();
    }

    @Test
    public static void allowedTimesTimePickerTest() {
        jdiAssert(allowedTimesTimePicker.isEnabled(), Matchers.is(true));
        jdiAssert(allowedTimesTimePicker.isDisabled(), Matchers.is(false));
        allowedTimesTimePicker.list().has().size(24);
        allowedTimesTimePicker.select("9");
        allowedTimesTimePicker.select("30");
        jdiAssert(allowedTimesTimePicker.selected(), Matchers.is("30"));
        jdiAssert(allowedTimesTimePicker.selected("30"), Matchers.is(true));
    }

    @Test
    public static void disabledTimePickerTest() {
        readOnlyTimePicker.items().has().size(12);
        jdiAssert(readOnlyTimePicker.isDisabled(), Matchers.is(true));
        jdiAssert(readOnlyTimePicker.get(3).isClickable(), Matchers.is(false));
    }

    @Test
    public static void readOnlyTimePickerTest() {
        disabledTimePicker.items().has().size(12);
        jdiAssert(disabledTimePicker.isDisabled(), Matchers.is(true));
        jdiAssert(disabledTimePicker.get(3).isClickable(), Matchers.is(false));
    }
}
