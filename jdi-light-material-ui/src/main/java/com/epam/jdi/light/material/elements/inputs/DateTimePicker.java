package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.inputs.DateTimePickerAssert;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * Represents Date / Time pickers MUI component on GUI.
 * <p>Date pickers and Time pickers provide a simple way to select a single value from a pre-determined set.
 * On mobile, pickers are best suited for display in confirmation dialog.
 * For inline display, such as on a form, consider using compact controls such as segmented dropdown buttons.</p>
 *
 * @see <a href="https://v4.mui.com/components/pickers/">Date / Time pickers MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/date_picker">MUI test page</a>
 */
public class DateTimePicker extends UIBaseElement<DateTimePickerAssert> {

    @Override
    public DateTimePickerAssert is() {
        return new DateTimePickerAssert().set(this);
    }

    /**
     * Gets input element of this DateTimePicker.
     *
     * @return input element of this DateTimePicker as {@link UIElement}
     */
    @JDIAction("Get input of '{name}'")
    private UIElement input() {
        return linked("input[class*='MuiInput-input']", "input");
    }

    /**
     * Gets list day number elements of this Date picker.
     *
     * @return list day number elements of this Date picker as {@link WebList}
     */
    @JDIAction("Get list of day numbers of '{name}'")
    private WebList calender() {
        return $$("//div[@class = 'MuiPickersBasePicker-pickerView']//p");
    }

    /**
     * Gets toggle button of this DateTimePicker.
     *
     * @return toggle button of DateTimePicker as {@link UIElement}
     */
    @JDIAction("Get toggle button of '{name}'")
    private UIElement toggle() {
        return core().find("button[aria-label*='change']");
    }

    /**
     * Gets list hour number elements of this Time picker
     *
     * @return list hour number elements of Time picker as {@link WebList}
     */
    @JDIAction("Get list of hour numbers of '{name}'")
    public WebList timer() {
        return $$("//div[@class = 'MuiPickersClock-clock']//span");
    }

    /**
     * Expands and Selects day number of Date picker
     *
     * @param value expected day number in a month as {@link String}
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void selectDate(String value) {
        if (!this.isExpanded()) {
            this.expand();
        }
        this.calender().select(value);
    }

    /**
     * Clicks on toggle button to expand Date / Time picker.
     */
    @JDIAction("Expand '{name}'")
    public void expand() {
        this.toggle().click();
    }

    /**
     * Clicks on Cancel button that is displayed on Date / Time picker to cancel changes and close.
     */
    @JDIAction("Cancel changes in '{name}' and close")
    public void cancel() {
        $("//div[contains(@role,'dialog')]//*[contains(text(),'Cancel')]").click();
    }

    /**
     * Clicks on OK button that is displayed on Date / Time picker to confirm changes and close.
     */
    @JDIAction("Confirm changes in '{name}' and close")
    public void confirm() {
        $("//div[contains(@role,'dialog')]//*[contains(text(),'OK')]").click();
    }

    /**
     * Sets text in input field.
     *
     * @param text expected text as {@link String}
     */
    @JDIAction("Set text in '{name}' input field")
    public void input(String text) {
        this.input().setText(text);
    }

    /**
     * Gets label text of this DateTimePicker.
     *
     * @return label text of this DateTimePicker as {@link String}
     */
    @JDIAction("Get '{name}' title")
    public String title() {
        return core().find("label").text();
    }

    /**
     * Checks if the Date picker (calendar) is expanded or not
     *
     * @return {@code true} if the Date picker (calendar) is expanded, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return this.calender().isExist();
    }

    /**
     * Gets text from input field of this DateTimePicker.
     *
     * @return text from input field of this DateTimePicker as {@link String}
     */
    @JDIAction("Get text from '{name}' input field")
    public String text() {
        return this.input().text();
    }
}
