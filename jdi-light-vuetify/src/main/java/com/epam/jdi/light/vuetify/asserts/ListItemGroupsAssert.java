package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroups;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListItemGroupsAssert extends UIAssert<ListItemGroupsAssert, ListItemGroups>{


    @JDIAction("Assert that '{name}' is active")
    public ListItemGroupsAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public ListItemGroupsAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has title")
    public ListItemGroupsAssert title() {
        jdiAssert(element().hasTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has border")
    public ListItemGroupsAssert border() {
        jdiAssert(element().hasBorder(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon")
    public ListItemGroupsAssert notBorder() {
        jdiAssert(element().hasBorder(), Matchers.is(false));
        return this;
    }


    @JDIAction("Assert that '{name}' has icon")
    public ListItemGroupsAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}'s label contains '{0}'")
    public ListItemGroupsAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }



    //    @JDIAction("Assert that '{name}' is displayed'")
    //    public ChipAssert displayed() {
    //        jdiAssert(element().isDisplayed(), Matchers.is(true));
    //        return this;
    //    }
    //
    //    @JDIAction("Assert that '{name}' is not displayed")
    //    public ChipAssert notDisplayed() {
    //        jdiAssert(element().isDisplayed(), Matchers.is(false));
    //        return this;
    //    }

    //    @JDIAction("Assert that {name}'s label contains '{0}'")
    //    public ChipAssert containsText(String text) {
    //        jdiAssert(element().getText(), Matchers.containsString(text));
    //        return this;
    //    }

    //    @JDIAction("Assert that '{name}' is selected")
    //    public ComboboxAssert selected(String value) {
    //        jdiAssert(element().isSelected(value), Matchers.is(true));
    //        return this;
    //    }
    //
    //    @JDIAction("Assert that '{name}' is selected")
    //    public ComboboxAssert selected(List<String> values) {
    //        jdiAssert(element().isSelected(values), Matchers.is(true));
    //        return this;
    //    }
    //
    //    @JDIAction("Assert that '{name}' is not selected")
    //    public ComboboxAssert notSelected(String value) {
    //        jdiAssert(element().isSelected(value), Matchers.is(false));
    //        return this;
    //    }
    //
    //    @JDIAction("Assert that '{name}' is not selected")
    //    public ComboboxAssert notSelected(List<String> values) {
    //        jdiAssert(element().isSelected(values), Matchers.is(false));
    //        return this;
    //    }
    //
    //    @JDIAction("Assert that '{name}' is disabled")
    //    public ComboboxAssert disabled() {
    //        jdiAssert(element().isDisabled(), Matchers.is(true));
    //        return this;
    //    }
    //
    //    @JDIAction("Assert that '{name}' is expanded")
    //    public ComboboxAssert active() {
    //        jdiAssert(element().isDisabled(), Matchers.is(false));
    //        return this;
    //    }
}
