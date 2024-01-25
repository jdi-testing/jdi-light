package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.angular.elements.enums.DialogPosition;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {
    @JDIAction(value = "Assert that '{name}' is opened", isAssert = true)
    public DialogAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' closed")
    public DialogAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

//    @JDIAction(value = "Assert that '{name}' has title", isAssert = true)
//    public DialogAssert title() {
//        jdiAssert(element().hasTitle(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
//        return this;
//    }

    @JDIAction(value = "Assert that '{name}' ", isAssert = true)
    public DialogAssert position(DialogPosition position) {
        jdiAssert(element().dialogActionsAlign(), Matchers.is(position));
        return this;
    }

    @JDIAction(value = "Assert that '{name}'", isAssert = true)
    public DialogAssert maxHeight(String value) {
        jdiAssert(element().maxHeight(), Matchers.is(value), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}'", isAssert = true)
    public DialogAssert minHeight(String value) {
        jdiAssert(element().minHeight(), Matchers.is(value), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}'", isAssert = true)
    public DialogAssert maxWidth(String value) {
        jdiAssert(element().maxWidth(), Matchers.is(value), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}'", isAssert = true)
    public DialogAssert minWidth(String value) {
        jdiAssert(element().minHeight(), Matchers.is(value), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}'", isAssert = true)
    public DialogAssert animationDuration(String value) {
        jdiAssert(element().animationDuration(), Matchers.is(value));
        return this;
    }
//
//    @JDIAction(value = "Assert that '{name}' has content", isAssert = true)
//    public DialogAssert content() {
//        jdiAssert(element().hasContent(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
//        return this;
//    }
//
//    @JDIAction(value = "Assert that '{name}' has action", isAssert = true)
//    public DialogAssert action() {
//        jdiAssert(element().hasAction(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
//        return this;
//    }
}
