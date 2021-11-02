package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    @Override
    public DialogAssert and() {
        return super.and();
    }

    @JDIAction("Assert that {name} is opened")
    public DialogAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} tooltip is opened")
    public DialogAssert tooltipIsOpened() {
        jdiAssert(element().tooltipIsOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} nested dialog is opened")
    public DialogAssert nestedDialogOpened() {
        jdiAssert(element().nestedDialogIsOpen(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public DialogAssert closed() {
        jdiAssert(element().isOpened(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} tooltip is closed")
    public DialogAssert tooltipIsClosed() {
        jdiAssert(element().tooltipIsOpened(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} nested dialog is closed")
    public DialogAssert nestedDialogClosed() {
        jdiAssert(element().nestedDialogIsOpen(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} is loading")
    public DialogAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is active")
    public DialogAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has title")
    public DialogAssert title(String title) {
        jdiAssert(element().getTitle(), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that {name} has title")
    public DialogAssert title(Matcher<String> matcher) {
        jdiAssert(element().getTitle(), Matchers.is(matcher));
        return this;
    }

    @JDIAction("Assert that {name} element has text")
    public DialogAssert elementText(int elNum, String text) {
        jdiAssert(element().elementText(elNum), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public DialogAssert cardText(String text) {
        jdiAssert(element().cardText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public DialogAssert cardText(Matcher<String> matcher) {
        jdiAssert(element().cardText(), Matchers.is(matcher));
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public DialogAssert elementSelected(int elNum) {
        jdiAssert(element().isSelected(elNum), Matchers.is(true), "Required element isn't selected");
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public DialogAssert elementNotSelected(Integer elNum) {
        jdiAssert(element().isNotSelected(elNum), Matchers.is(true), "Required element is selected");
        return this;
    }
}
