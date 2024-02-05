package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.DateTimeNativePicker;
import com.epam.jdi.light.material.elements.inputs.DateTimePicker;

public class DateTimePickersPage extends WebPage {

    // @todo #5297 Check if locators with classses can be used
    @UI("//*[@id = 'date-picker-inline-label']/parent::div")
    public static DateTimePicker inlineDatePicker;

    @UI("//*[@id = 'date-picker-dialog-label']/parent::div")
    public static DateTimePicker dialogPicker;

    @UI("//*[@id = 'time-picker-label']/parent::div")
    public static DateTimePicker timePicker;

    @UI("//*[@id = 'date-label']/parent::div")
    public static DateTimeNativePicker birthdayPicker;

    @UI("//*[@id = 'datetime-local-label']/parent::div")
    public static DateTimeNativePicker appointmentPicker;

    @UI("//*[text()='Alarm clock']/..")
    public static DateTimeNativePicker alarmPicker;
}
