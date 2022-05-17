package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import org.apache.commons.lang3.RegExUtils;
import org.openqa.selenium.By;

import java.util.Locale;

/**
 * Represents Slider MUI component on GUI.
 * <p>Sliders reflect a range of values along a bar, from which users may select a single value.
 * They are ideal for adjusting settings such as volume, brightness, or applying image filters.</p>
 *
 * @see <a href="https://v4.mui.com/components/slider/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/sliders">MUI test page</a>
 */
public interface ISlider extends CanBeDisabled {

    /**
     * Contains named constants representing Slider's orientation
     */
    enum Orientation {
        VERTICAL, HORIZONTAL
    }

    /**
     * Contains named constants representing Slider's type
     */
    enum Type {
        DISCRETE, CONTINUOUS
    }

    /**
     * Gets Slider's label.
     *
     * @return Slider's label as {@link UIElement}
     */
    @JDIAction(value = "Get '{name}' slider label")
    default UIElement sliderLabel() {
        return core().find(".MuiSlider-valueLabel");
    }

    /**
     * Gets Slider's slider element.
     *
     * @return Slider's slider as {@link UIElement}
     */
    @JDIAction(value = "Get '{name}''s slider")
    default UIElement slider() {
        return core().find("[role=slider]");
    }

    /**
     * Gets Slider's track.
     *
     * @return Slider's track as {@link UIElement}
     */
    @JDIAction(value = "Get '{name}''s track")
    default UIElement track() {
        return core().find(".MuiSlider-track");
    }

    /**
     * Gets Slider's thumb by index.
     *
     * @param index thumb's index. Starting from 1
     * @return Slider's label as {@link UIElement}
     */
    @JDIAction(value = "Get '{name}''s thumb")
    default UIElement thumb(int index) {
        return core().finds(".MuiSlider-thumb").get(index);
    }

    /**
     * Gets Slider's thumb value by index.
     *
     * @param index thumb's index. Starting from 1
     * @return Slider's thumb value as {@link String}
     */
    @JDIAction(value = "Get '{name}''s value")
    default String value(int index) {
        return thumb(index).attr("aria-valuenow");
    }

    /**
     * Gets Slider's thumb minimum value by index.
     *
     * @param index thumb's index. Starting from 1
     * @return Slider's thumb minimum value as {@link String}
     */
    @JDIAction(value = "Get '{name}''s minimum value")
    default String min(int index) {
        return thumb(index).attr("aria-valuemin");
    }

    /**
     * Gets Slider's thumb maximum value by index.
     *
     * @param index thumb's index. Starting from 1
     * @return Slider's thumb maximum value as {@link String}
     */
    @JDIAction(value = "Get '{name}''s maximum value")
    default String max(int index) {
        return thumb(index).attr("aria-valuemax");
    }

    /**
     * Sets Slider's thumb value by index.
     *
     * @param index thumb's index. Starting from 1
     * @param value value to set
     */
    @JDIAction(value = "Set value '{1}' for '{name}'")
    default void setValue(int index, String value) {
        if (this.isDisabled()) {
            return;
        }
        double minVal = Double.parseDouble(min(index));
        double maxVal = Double.parseDouble(max(index));
        double percentsInUnit = 100d / (maxVal - minVal);
        double newStyleValue = (Double.parseDouble(value) - minVal) * percentsInUnit;

        String thumbStyle = thumb(index).getAttribute("style");
        String newThumbStyle = RegExUtils.replacePattern(thumbStyle, "([\\d.]+)",
                String.valueOf(newStyleValue));

        thumb(index).setAttribute("aria-valuenow", value);
        thumb(index).setAttribute("style", newThumbStyle);
        core().findFirst("input").setAttribute("value", value);
        thumb(index).click();
    }

    /**
     * Sets Slider's thumb value by index.
     *
     * @param index thumb's index. Starting from 1
     * @param value value to set
     */
    @JDIAction(value = "Set value '{1}' for '{name}'")
    default void setValue(int index, double value) {
        setValue(index, String.valueOf(value));
    }

    /**
     * Sets Slider's thumb value by index.
     *
     * @param index thumb's index. Starting from 1
     * @param value value to set
     */
    @JDIAction(value = "Set value '{1}' for '{name}'")
    default void setValue(int index, int value) {
        setValue(index, String.valueOf(value));
    }

    /**
     * Gets Slider's orientation.
     *
     * @return Slider's orientation as {@link Orientation}
     */
    @JDIAction(value = "Get '{name}''s orientation")
    default Orientation orientation() {
        return Orientation.valueOf(thumb(1).attr("aria-orientation").toUpperCase(Locale.ROOT));
    }

    /**
     * Gets Slider's type.
     *
     * @return Slider's type as {@link Type}
     */
    @JDIAction(value = "Get '{name}''s type")
    default Type type() {
        return finds(".MuiSlider-mark").isNotEmpty() ? Type.DISCRETE : Type.CONTINUOUS;
    }

    /**
     * Performs Slider's thumb drag and drop to value.
     *
     * @param index thumb's index. Starting from 1
     * @param value value to set
     */
    default void dragAndDropThumbTo(int index, int value) {
        dragAndDropThumbTo(index, String.valueOf(value));
    }

    /**
     * Performs Slider's thumb drag and drop to value.
     *
     * @param index thumb's index. Starting from 1
     * @param value value to set
     */
    default void dragAndDropThumbTo(int index, double value) {
        dragAndDropThumbTo(index, String.valueOf(value));
    }

    /**
     * Performs Slider's thumb drag and drop to value.
     *
     * @param index thumb's index. Starting from 1
     * @param value value to set
     */
    @JDIAction(value = "drag and drop '{name}''s thumb to value '{1}'")
    default void dragAndDropThumbTo(int index, String value) {
        Orientation orientation = orientation();
        double minValue = Double.parseDouble(min(index));
        double maxValue = Double.parseDouble(max(index));
        double coreSize;

        if(orientation.equals(Orientation.HORIZONTAL)) {
            coreSize = core().getSize().getWidth();
        } else {
            coreSize = core().getSize().getHeight();
        }

        double pixelsInUnit = coreSize / (maxValue - minValue);
        double offset = (Double.parseDouble(value) - Double.parseDouble(value(index))) * pixelsInUnit;

        if (orientation.equals(Orientation.HORIZONTAL)) {
            thumb(index).dragAndDropTo((int) Math.round(offset), 0);
        } else {
            thumb(index).dragAndDropTo(0, -(int) Math.round(offset));
        }
    }
}
