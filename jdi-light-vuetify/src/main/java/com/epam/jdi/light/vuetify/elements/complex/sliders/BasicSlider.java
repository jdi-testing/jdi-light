package com.epam.jdi.light.vuetify.elements.complex.sliders;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.sliders.BasicSliderAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;

public abstract class BasicSlider<T extends BasicSlider<?, ?>, A extends BasicSliderAssert<?, ?>> extends UIBaseElement<A> implements HasLabel, HasTheme, IsDense {

    private static final String DISABLED = "v-slider--disabled";
    private static final String APPEND_ICON = "v-input__icon--append";
    private static final String VERTICAL = "v-slider--vertical";
    private static final String ERROR_MESSAGE = ".error--text .v-messages__message";
    private static final String HIDE_DETAILS = "v-input--hide-details";
    private static final String HIDE_SPIN_BUTTON = "v-input--hide-spin-buttons";
    private static final String INVERSE_LABEL = "v-input__slider--inverse-label";
    private static final String READONLY = "v-slider--readonly";
    private static final String SUCCESS = "success";
    private static final String PREPEND_ICON = "v-input__icon--prepend";
    private static final String SUCCESS_MESSAGES = ".success--text .v-messages__message";
    private static final String MESSAGES = "v-messages__message";
    private static final String TRACK_FILL = "v-slider__track-fill";

    @JDIAction("Check '{name}' is append icon")
    public boolean isAppendIcon() {
        return core().hasClass(APPEND_ICON);
    }

    @JDIAction("Get {name}'s  color")
    public String color() {
        return core().css("color");
    }

    @JDIAction("Get {name}'s background color")
    public String backgroundColor() {
        return core().css("background-color");
    }

    @JDIAction("Get theme of '{name}'")
    public String theme() {
        return core().classes().stream()
                .filter(c -> c.contains("theme"))
                .findFirst()
                .get();
    }

    @JDIAction("Check if '{name}' has error message")
    public boolean hasError() {
        return core().attr("class").contains("error");
    }

    @JDIAction("Get error message of '{name}'")
    public String errorMessage() {
        return core().find(ERROR_MESSAGE).getText();
    }

    @JDIAction("Check if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasClass(DISABLED);
    }

    @JDIAction("Get height of '{name}'")
    public String height() {
        return core().getCssValue("height");
    }

    @JDIAction("Check if '{name}' hide details")
    public boolean isHideDetails() {
        return core().hasClass(HIDE_DETAILS);
    }

    @JDIAction("Check if '{name}' is hide spin button")
    public boolean isHideSpinButton() {
        return core().hasClass(HIDE_SPIN_BUTTON);
    }

    @JDIAction("Check if '{name}' has inverse label")
    public boolean hasInverseLabel() {
        return core().hasClass(INVERSE_LABEL);
    }

    @JDIAction("Get max of '{name}'")
    public String max() {
        return core().attr("max");
    }

    @JDIAction("Get min of '{name}'")
    public String min() {
        return core().attr("min");
    }

    @JDIAction("Check '{name}' is append icon")
    public boolean isPrependIcon() {
        return core().hasClass(PREPEND_ICON);
    }

    @JDIAction("Check if '{name}' readonly")
    public boolean isReadonly() {
        return core().hasClass(READONLY);
    }

    @JDIAction("Get min of '{name}'")
    public String step() {
        return core().attr("step");
    }

    @JDIAction("Check if '{name}' is success")
    public boolean isSuccess() {
        return core().hasClass(SUCCESS);
    }

    @JDIAction("Get success messages of '{name}'")
    public String successMessages() {
        return core().find(SUCCESS_MESSAGES).getText();
    }

    @JDIAction("Get track fill color of '{name}'")
    public String trackFillColor() {
        return core().find(TRACK_FILL).classes().stream()
                .findFirst()
                .get();
    }

    @JDIAction("Check if '{name}' is success")
    public boolean isValidateOnBlur() {
        return !core().hasClass(MESSAGES);
    }

    @JDIAction("Check if '{name}' is vertical")
    public boolean isVertical() {
        return core().hasClass(VERTICAL);
    }
}
