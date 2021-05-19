package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;

/**
 * To see an example of Material Date and Time pickers
 * please visit https://material.io/components/date-pickers#usage.
 */


public class DateTimePickersPage extends WebPage {

    @JDropdown(
            root = "//*[@id = 'date-picker-inline-label']/parent::div",
            value = "//*[@id ='date-picker-inline']",
            list = "//*[@id = 'date-picker-inline-label']/parent::div /ancestor::body " +
                    "//div[@class = 'MuiPickersBasePicker-pickerView']//p",
            expand = "//span[@class = 'MuiIconButton-label']")
    public static Dropdown inlineDatePicker;

    @JDropdown(
            root = "//*[@id = 'date-picker-dialog-label']/parent::div",
            value = "//*[@id ='date-picker-dialog']",
            list = "//*[@id = 'date-picker-dialog-label']/parent::div /ancestor::body " +
                    "//div[@class = 'MuiPickersBasePicker-pickerView']//p",
            expand = "//span[@class = 'MuiIconButton-label']")
    public static Dropdown dialogPicker;

    @JDropdown(root = "//*[@id = 'time-picker-label']/parent::div", value = "//*[@id ='time-picker']",
            list = "//*[@id = 'time-picker-label']/parent::div /ancestor::body //div[@class = 'MuiPickersClock-clock']" +
                    "//span",
            expand = "//span[@class = 'MuiIconButton-label']")
    public static Dropdown timePicker;

    @JDropdown(root = "//*[@id = 'date-label']/parent::div", value = "//*[@id ='date']")
    public static Dropdown birthdayPicker;

    @JDropdown(root = "//*[@id = 'datetime-local-label']/parent::div", value = "//*[@id ='datetime-local']")
    public static Dropdown appointmentPicker;

    @JDropdown(root = "//*[text()='Alarm clock']/..", value = "//*[@id ='time']")
    public static Dropdown alarmPicker;
}
