package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIPicker;
import com.epam.jdi.light.material.elements.inputs.DateTimePickers;

public class DateTimePickersFrame extends WebPage {
    @JDIPicker
    public static DateTimePickers pickers;

    @UI("//p[contains(text(),'10')]")
    public static DateTimePickers dateTenBtn;

    @UI("//span[contains(text(),'Cancel')]")
    public static DateTimePickers dateTimePopUpCancelButton;

    @UI("//span[contains(text(),'OK')]")
    public static DateTimePickers dateTimePopUpOkButton;

    @UI("//span[contains(text(),'10')]")
    public static DateTimePickers timeTen;

}
