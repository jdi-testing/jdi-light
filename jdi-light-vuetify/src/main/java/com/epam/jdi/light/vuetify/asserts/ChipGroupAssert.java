package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroups;
import org.hamcrest.Matchers;


public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroups> {

    @JDIAction("Assert that {name}'s label contains '{0}'")
    public ChipGroupAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has filter")
    public ChipGroupAssert filter() {
        jdiAssert(element().hasFilter(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not filter")
    public ChipGroupAssert notFilter() {
        jdiAssert(element().hasNoFilter(), Matchers.is(true));
        return this;
    }

}
