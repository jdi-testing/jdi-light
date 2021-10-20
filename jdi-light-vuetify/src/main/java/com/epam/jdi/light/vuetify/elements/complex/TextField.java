package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.vuetify.asserts.TextFieldAssert;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.driver.get.DriverData.getOs;

public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasLabel, HasPlaceholder, IsInput {

    private final String LABEL = "label";
    private final String INPUT = "input";
    private final String SLOT = ".v-text-field__slot";
    private final String MESSAGE = ".v-messages__message";
    private final String DETAILS = ".v-text-field__details";
    private final String COUNTER = ".v-counter";
    private final String PREPEND_OUTER = ".v-input__prepend-outer";
    private final String PREPEND_INNER = ".v-input__prepend-inner";
    private final String APPEND_OUTER = ".v-input__append-outer";
    private final String APPEND_INNER = ".v-input__append-inner";

    @JDIAction("Get '{name}' details")
    public UIElement getDetails() {
        return find(DETAILS);
    }

    @JDIAction("Get '{name}' message")
    public String getMessage() {
        WebList message = finds(MESSAGE);
        return message.isEmpty() ? "" : message.first().getText();
    }

    @JDIAction("Get '{name}' counter")
    public String getCounter() {
        WebList counter = finds(COUNTER);
        return counter.isEmpty() ? "" : counter.first().getText();
    }

    @JDIAction("Get '{name}' prepend outer")
    public UIElement getPrependOuter() {
        WebList prependOuter = finds(PREPEND_OUTER);
        return prependOuter.isEmpty() ? null : prependOuter.first();
    }

    @JDIAction("Get '{name}' prepend inner")
    public UIElement getPrependInner() {
        WebList prependInner = finds(PREPEND_INNER);
        return prependInner.isEmpty() ? null : prependInner.first();
    }

    @JDIAction("Get '{name}' append inner")
    public UIElement getAppendInner() {
        WebList appendInner = finds(APPEND_INNER);
        return appendInner.isEmpty() ? null : appendInner.first();
    }

    @JDIAction("Get '{name}' append outer")
    public UIElement getAppendOuter() {
        WebList appendOuter = finds(APPEND_OUTER);
        return appendOuter.isEmpty() ? null : appendOuter.first();
    }

    @Override
    public String labelText(){
        return find(LABEL).labelText();
    }

    @Override
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            find(INPUT).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            find(INPUT).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    @JDIAction("Clear '{name}' text field and set text")
    public void clearAndSetText(String text) {
        this.clear();
        find(INPUT).sendKeys(text + Keys.ENTER);
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
