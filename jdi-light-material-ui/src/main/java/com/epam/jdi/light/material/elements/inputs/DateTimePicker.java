package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.DateTimePickerAssert;
import com.epam.jdi.light.material.interfaces.inputs.IDateTimePicker;
import org.openqa.selenium.Keys;

/**
 * Represents Date / Time pickers MUI component on GUI.
 * <p>Date pickers and Time pickers provide a simple way to select a single value from a pre-determined set.
 * On mobile, pickers are best suited for display in confirmation dialog.
 * For inline display, such as on a form, consider using compact controls such as segmented dropdown buttons.</p>
 *
 * @see <a href="https://v4.mui.com/components/pickers/">Date / Time pickers MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/date_picker">MUI test page</a>
 */
public class DateTimePicker extends UIBaseElement<DateTimePickerAssert> implements IDateTimePicker {

    @Override
    public DateTimePickerAssert is() {
        return new DateTimePickerAssert().set(this);
    }


    @Override
    public void value(String value) {
        input().sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
    }

}
