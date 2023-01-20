package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static io.github.com.StaticSite.dateTimePickersPage;
import static io.github.com.pages.inputs.DateTimePickersPage.alarmPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.appointmentPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.birthdayPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.dialogPicker;
import static io.github.com.pages.inputs.DateTimePickersPage.inlineDatePicker;
import static io.github.com.pages.inputs.DateTimePickersPage.timePicker;

public class DateTimePickersTests extends TestsInit {

    @BeforeMethod
    public void chooseSection() {
        dateTimePickersPage.open();
        dateTimePickersPage.isOpened();
    }

    @Test
    public void datePickerInlineTest() {
        inlineDatePicker.has().title("Date picker inline");

        inlineDatePicker.value("10/10/2022");
        inlineDatePicker.has().text("10/10/2022");

    }

    @Test
    public void datePickerDialogTest() {
        dialogPicker.has().title("Date picker dialog");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dt = LocalDate.of(2021, 10, 10);
        dialogPicker.value(dt.atStartOfDay(), formatter);
        dialogPicker.has().text("10/10/2021");
    }

    @Test
    public void timePickerTest() {
        timePicker.has().title("Time picker");

        timePicker.value("05:30 PM");
        timePicker.has().text("05:30 PM");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("hh:mm a");
        timePicker.value(now, dt);
        timePicker.has().text(dt.format(now));
    }

    @Test
    public void birthdayPickerTest() {
        birthdayPicker.has().title("Birthday")
                .has().text("2017-05-24");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        birthdayPicker.value(now, dt);
        birthdayPicker.has().text(dt.format(now));
    }

    @Test
    public void appointmentPickerTest() {
        appointmentPicker.has().title("Next appointment")
                .has().text("2017-05-24T10:30");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .appendPattern("yyyy-MM-dd")
                .appendLiteral("T")
                .appendPattern("HH:mm").toFormatter();
        appointmentPicker.value(now, formatter);
        appointmentPicker.has().text(now.format(formatter));
    }

    @Test
    public void alarmPickerTest() {
        alarmPicker.has().title("Alarm clock")
                .has().text("07:30");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
        alarmPicker.value(now, dt);
        alarmPicker.has().text(dt.format(now));
    }
}
