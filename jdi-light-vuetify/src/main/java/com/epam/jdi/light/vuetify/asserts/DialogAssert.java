package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    @Override
    public DialogAssert and() {
        return super.and();
    }

    @JDIAction("Assert that {name} is opened")
    public DialogAssert opened() {
        waitCondition(() -> element().isOpened());
        jdiAssert(element().isOpened() ? "is opened" : "is closed",
            Matchers.is("is opened"));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public DialogAssert closed() {
        jdiAssert(element().isOpened() ? "is opened" : "is closed",
            Matchers.is("is closed"));
        return this;
    }

    @JDIAction("Assert that {name} is active")
    public DialogAssert active() {
        jdiAssert(element().isActive() ? "is active" : "is not active",
            Matchers.is("is active"));
        return this;
    }

    @JDIAction("Assert that {name} is fullscreen")
    public DialogAssert fullscreen() {
        jdiAssert(element().isFullscreen() ? "is fullscreen" : "is not fullscreen",
            Matchers.is("is fullscreen"));
        return this;
    }

    @JDIAction("Assert that {name} is persistent")
    public DialogAssert persistent() {
        jdiAssert(element().isPersistent() ? "is persistent" : "is not persistent",
            Matchers.is("is persistent"));
        return this;
    }

    @JDIAction("Assert that {name} is scrollable")
    public DialogAssert scrollable() {
        jdiAssert(element().isScrollable() ? "is scrollable" : "is not scrollable",
            Matchers.is("is scrollable"));
        return this;
    }

    @JDIAction("Assert that {name} has visible {0} in dialog content")
    public DialogAssert visibleContent(UIElement element) {
        jdiAssert(element().isVisibleContent(element) ? "is visible" : "is not visible",
            Matchers.is("is visible"));
        return this;
    }

    @JDIAction("Assert that {name} has not visible {0} in dialog content")
    public DialogAssert notVisibleContent(UIElement element) {
        jdiAssert(element().isVisibleContent(element) ? "is visible" : "is not visible",
            Matchers.is("is not visible"));
        return this;
    }
}
