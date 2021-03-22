package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.DateTimePickers;

public class DateTimePickersFrame  extends Section {
    @UI(".MuiSvgIcon-root")
    public DateTimePickers dateTimePickersIcon;

    @UI("//p[contains(text(),'10')]")
    public DateTimePickers dateTen;

    @UI("//span[contains(text(),'10')]")
    public DateTimePickers timeTen;

    @UI(".MuiInputBase-input")
    public DateTimePickers dateTimePickersInput;

    @UI("//span[contains(text(),'OK')]")
    public DateTimePickers dateTimePickersOkButton;

    @UI("//span[contains(text(),'Cancel')]")
    public DateTimePickers dateTimePickersCancelButton;

}
