package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.DateTimePickersPage.*;
import static org.hamcrest.Matchers.containsString;

public class DateTimePickersTests extends TestsInit {

    @BeforeMethod
    public void chooseSection() {
        openSection("Date / Time");
    }

    @Test
    public void pickDateViaInlineDropdownTest() {
        inlineDatePicker.select("12");
        inlineDatePicker.has().text(containsString("/12/"));
    }

    @Test
    public void pickDateViaInlineTextFieldTest() {
        inlineDatePicker.value().setText("10/10/2021");
        inlineDatePicker.has().text("10/10/2021");
    }

    @Test
    public void pickDateViaDialogPopUpTest(){
        dialogPicker.expand();
        dialogPicker.select("12");
        dialogPicker.command("ENTER");
        dialogPicker.has().text(containsString("/12/"));
    }

    @Test
    public void escapeDatePickingViaDialogPopUpTest(){
        dialogPicker.expand();
        dialogPicker.select("12");
        dialogPicker.command("ESCAPE");
        dialogPicker.has().text("08/18/2014");
    }

    @Test
    public void pickDateViaDialogTextFieldTest(){
        inlineDatePicker.value().setText("10/10/2021");
        inlineDatePicker.has().text("10/10/2021");
    }

    @Test
    public void pickTimeViaTimePopUpTest(){
        timePicker.expand();
        timePicker.list().get("5").click(1, 1);
        timePicker.list().get("15").click(3, 3);
        timePicker.command("ENTER");
        timePicker.has().text("05:14 PM");
    }

    @Test
    public void pickTimeViaTimeTextFieldTest(){
        timePicker.value().setText("05:14 AM");
        timePicker.has().text("05:14 AM");
    }

    @Test
    public void escapeTimePickingUsingTimePopUpTest(){
        timePicker.expand();
        timePicker.list().get("5").click(1, 1);
        timePicker.list().get("15").click(3, 3);
        timePicker.command("ESCAPE");
        timePicker.has().text("09:11 PM");
    }

    @Test
    public void pickDateViaBirthdayPickerTextField(){
        birthdayPicker.has().text("2017-05-24");
        birthdayPicker.value().setText("2021-04-05");
        birthdayPicker.has().text("2021-04-05");
    }

    @Test
    public void pickAppointmentViaAppointmentPickerTextField(){
        appointmentPicker.has().text("2017-05-24T10:30");
        appointmentPicker.value().setText("2021-11-12T11:12");
        appointmentPicker.has().text("2021-11-12T11:12");
    }

    @Test
    public void pickTimeViaAlarmPickerTextField(){
        alarmPicker.has().text("07:30");
        alarmPicker.value().setText("08:00");
        alarmPicker.has().text("08:00");
    }
}
