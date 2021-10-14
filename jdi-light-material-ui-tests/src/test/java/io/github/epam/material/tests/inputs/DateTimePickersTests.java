package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dateTimePickersPage;
import static io.github.com.pages.inputs.DateTimePickersPage.alarmPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.appointmentPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.birthdayPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.dialogPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.inlineDatePicker;
import static io.github.com.pages.inputs.DateTimePickersPage.timePicker;

/**
 * To see an example of Material Date and Time pickers
 * please visit https://material.io/components/date-pickers#usage.
 */

public class DateTimePickersTests extends TestsInit {

    @BeforeMethod
    public void chooseSection() {
        dateTimePickersPage.open();
    }

    @Test
    public void datePickerInlineTest() {
        inlineDatePicker.has().title("Date picker inline");
//
        inlineDatePicker.input("10/10/2022");
        inlineDatePicker.has().text("10/10/2022");
        inlineDatePicker.selectDate("22");
        inlineDatePicker.has().text(containsString("/22/"));
    }

    @Test
    public void datePickerDialogTest() {
        dialogPicker.has().title("Date picker dialog");
        dialogPicker.expand();
        dialogPicker.selectDate("12");
        dialogPicker.confirm();
        dialogPicker.has().text(containsString("/12/"));

        dialogPicker.expand();
        dialogPicker.selectDate("11");
        dialogPicker.cancel();
        dialogPicker.has().text("08/12/2014");

        dialogPicker.input("10/10/2021");
        dialogPicker.has().text("10/10/2021");
    }

    @Test
    public void timePickerTest() {
        timePicker.has().title("Time picker");

        timePicker.expand();
        timePicker.timer().get("5").click(0, 0);
        timePicker.timer().get("30").click(15, 0);
        timePicker.confirm();
        timePicker.has().text("05:30 PM");

        timePicker.expand();
        timePicker.timer().get("11").click(0, 0);
        timePicker.timer().get("15").click(15, 0);
        timePicker.cancel();
        timePicker.has().text("05:30 PM");

        timePicker.input("05:35 AM");
        timePicker.has().text("05:35 AM");
    }

    @Test
    public void birthdayPickerTest() {
        birthdayPicker.has().title("Birthday");

        birthdayPicker.has().text("2017-05-24");
        birthdayPicker.input("2021-04-05");
        birthdayPicker.has().text("2021-04-05");
    }

    @Test
    public void appointmentPickerTest() {
        appointmentPicker.has().title("Next appointment");

        appointmentPicker.has().text("2017-05-24T10:30");
        appointmentPicker.input("2021-11-12T11:12");
        appointmentPicker.has().text("2021-11-12T11:12");
    }

    @Test
    public void alarmPickerTest() {
        alarmPicker.has().title("Alarm clock");

        alarmPicker.has().text("07:30");
        alarmPicker.input("10:15");
        alarmPicker.has().text("10:15");
    }
}
