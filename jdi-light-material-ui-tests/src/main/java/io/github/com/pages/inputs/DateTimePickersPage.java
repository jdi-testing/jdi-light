package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.DateTimePicker;

/**
 * To see an example of Material Date and Time pickers
 * please visit https://material.io/components/date-pickers#usage.
 */


public class DateTimePickersPage extends WebPage {

    @UI("//*[@id = 'date-picker-inline-label']/parent::div")
    public static DateTimePicker inlineDatePicker;

    @UI("//*[@id = 'date-picker-dialog-label']/parent::div")
    public static DateTimePicker dialogPicker;

    @UI("//*[@id = 'time-picker-label']/parent::div")
    public static DateTimePicker timePicker;

    @UI("//*[@id = 'date-label']/parent::div")
    public static DateTimePicker birthdayPicker;

    @UI("//*[@id = 'datetime-local-label']/parent::div")
    public static DateTimePicker appointmentPicker;

    @UI("//*[text()='Alarm clock']/..")
    public static DateTimePicker alarmPicker;
}
