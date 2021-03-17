package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Select;
import org.hamcrest.Matchers;

import java.util.List;

public class SelectAssert extends UIAssert<SelectAssert, Select> {

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public SelectAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public SelectAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public SelectAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public SelectAssert itemTextDisplayed(String itemText) {
        jdiAssert(element().isItemDisplayed(itemText), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public SelectAssert itemsTextDisplayed(List<String> items) {
        items.forEach(item -> jdiAssert(element().isItemContains(item),
            Matchers.is(true)));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public SelectAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }
}
