package io.github.epam.material.tests.inputs;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dateTimePickersPage;
import static io.github.com.pages.inputs.DateTimePickersPage.alarmPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.appointmentPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.birthdayPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.dialogPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.inlineDatePicker;
import static io.github.com.pages.inputs.DateTimePickersPage.timePicker;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Material Date and Time pickers
 * please visit https://material.io/components/date-pickers#usage.
 */

public class DateTimePickersTests extends TestsInit {
    private Timer timer = new Timer(2000L);

    @BeforeMethod
    public void chooseSection() {
        dateTimePickersPage.open();
    }

    @Test
    public void datePickerInlineTest() {
        inlineDatePicker.iCore().label().has().text("Date picker inline");

        inlineDatePicker.select("12");
        inlineDatePicker.has().text(containsString("/12/"));

        inlineDatePicker.value().setText("10/10/2022");
        inlineDatePicker.has().text("10/10/2022");
    }

    @Test
    public void datePickerDialogTest() {
        dialogPicker.iCore().label().has().text("Date picker dialog");
        dialogPicker.expand();
        dialogPicker.select("12");
        dialogPicker.command("ENTER");
        timer.wait(() -> dialogPicker.has().text(containsString("/12/")));

        dialogPicker.expand();
        dialogPicker.select("11");
        dialogPicker.command("ESC");
        timer.wait(() -> dialogPicker.has().text("08/12/2014"));

        dialogPicker.value().setText("10/10/2021");
        dialogPicker.has().text("10/10/2021");
    }

    @Ignore
    @Test
    public void timePickerTest() {
        timePicker.iCore().label().has().text("Time picker");

        timePicker.expand();
        timer.wait(() -> timePicker.list().get("5").isDisplayed());
        timePicker.list().get("5").click(0, 0);
        timePicker.list().get("30").click(15, 0);
        timePicker.command("ENTER");
        timer.wait(() -> timePicker.has().text("05:30 PM"));

        timePicker.expand();
        timer.wait(() -> timePicker.list().get("11").isDisplayed());
        timePicker.list().get("11").click(0, 0);
        timePicker.list().get("15").click(15, 0);
        timePicker.command("ESC");
        timer.wait(() -> timePicker.has().text("05:30 PM"));

        timePicker.value().setText("05:35 AM");
        timePicker.has().text("05:35 AM" );
    }

    @Test
    public void birthdayPickerTest() {
        birthdayPicker.iCore().label().has().text("Birthday");

        birthdayPicker.has().text("2017-05-24");
        birthdayPicker.value().setText("2021-04-05");
        birthdayPicker.has().text("2021-04-05");
    }

    @Test
    public void appointmentPickerTest() {
        appointmentPicker.iCore().label().has().text("Next appointment");

        appointmentPicker.has().text("2017-05-24T10:30");
        appointmentPicker.value().setText("2021-11-12T11:12");
        appointmentPicker.has().text("2021-11-12T11:12");
    }

    @Test
    public void alarmPickerTest() {
        alarmPicker.iCore().label().has().text("Alarm clock");

        alarmPicker.has().text("07:30");
        alarmPicker.value().setText("08:00");
        alarmPicker.has().text("08:00");
    }
}
