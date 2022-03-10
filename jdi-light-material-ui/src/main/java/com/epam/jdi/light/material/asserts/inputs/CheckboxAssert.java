package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        jdiAssert(element().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public CheckboxAssert unchecked() {
        jdiAssert(element().isChecked() ? "is checked" : "is unchecked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction
    public CheckboxAssert iconSize(int height, int width) {
        Icon icon = new Icon().setCore(Icon.class, element().find("svg"));
        icon.has().height(height).and().has().width(width);
        return this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public CheckboxAssert color(String color) {
        jdiAssert(element().getColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled() ? "is enabled" : "is disabled", Matchers.is("is enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled() {
        jdiAssert(element().isEnabled() ? "is enable" : "is disabled", Matchers.is("is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}''s label has position {0}")
    public CheckboxAssert labelPosition(Position position) {
        jdiAssert(element().labelPosition(), Matchers.is(position));
        return this;
    }

}
