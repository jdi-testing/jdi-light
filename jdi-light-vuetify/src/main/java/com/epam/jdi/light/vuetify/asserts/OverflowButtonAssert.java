package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OverflowButtonAssert extends UIAssert<OverflowButtonAssert, OverflowButton> {

    @JDIAction("Assert that {name} is expanded")
    public OverflowButtonAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public OverflowButtonAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is select '{0}'")
    public OverflowButtonAssert selected(String text) {
        jdiAssert(element().selected(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} message is '{0}'")
    public OverflowButtonAssert message(String text) {
        jdiAssert(element().message(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} placeholder is '{0}'")
    public OverflowButtonAssert placeholder(String text) {
        jdiAssert(element().placeholder(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} counter is '{0}'")
    public OverflowButtonAssert counter(String text) {
        jdiAssert(element().counterMessage(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} is editable")
    public OverflowButtonAssert editable() {
        jdiAssert(element().isEditable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is read only")
    public OverflowButtonAssert readOnly() {
        jdiAssert(element().readOnly(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has progress bar ")
    public OverflowButtonAssert hasProgressBar() {
        jdiAssert(element().hasProgressBar(), Matchers.is(true));
        return this;
    }
}
