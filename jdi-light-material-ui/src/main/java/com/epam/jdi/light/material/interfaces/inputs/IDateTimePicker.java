package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface IDateTimePicker extends ICoreElement {

    /**
     * Sets value of this DateTimePicker.
     *
     * @param value - value to set as {@link LocalDateTime}
     * @param format - format for setting value as {@link DateTimeFormatter}
     */
    default void value(LocalDateTime value, DateTimeFormatter format) {
        value(value.format(format));
    }

    /**
     * Sets value of this DateTimePicker.
     *
     * @param value - value to set as {@link String}
     */
    void value(String value);

    /**
     * Gets value of this DateTimePicker.
     *
     * @return value of this DateTimePicker as {@link String}
     */
    default String value() {
        return input().getValue();
    }

    /**
     * Gets label text of this DateTimePicker.
     *
     * @return label text of this DateTimePicker as {@link String}
     */
    @JDIAction("Get '{name}' title")
    default String title() {
        return core().find("label").text();
    }

    /**
     * Gets input element of this DateTimePicker.
     *
     * @return input element of this DateTimePicker as {@link UIElement}
     */
    @JDIAction("Get input of '{name}'")
    default UIElement input() {
        return core().find("input[class*='MuiInput-input']", "input");
    }

}
