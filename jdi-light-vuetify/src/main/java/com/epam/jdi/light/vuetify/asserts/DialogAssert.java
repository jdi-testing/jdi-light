package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> implements ThemeAssert<DialogAssert, Dialog> {

    @Override
    public DialogAssert and() {
        return super.and();
    }

    @JDIAction(value = "Assert that '{name}' is opened", isAssert = true)
    public DialogAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true), "Dialog is closed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is closed", isAssert = true)
    public DialogAssert closed() {
        jdiAssert(element().isOpened(), Matchers.is(false), "Dialog is opened");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is active", isAssert = true)
    public DialogAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Dialog is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not active", isAssert = true)
    public DialogAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Dialog is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fullscreen", isAssert = true)
    public DialogAssert fullscreen() {
        jdiAssert(element().isFullscreen(), Matchers.is(true), "Dialog is not fullscreen");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not fullscreen", isAssert = true)
    public DialogAssert notFullscreen() {
        jdiAssert(element().isFullscreen(), Matchers.is(false), "Dialog is fullscreen");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is persistent", isAssert = true)
    public DialogAssert persistent() {
        jdiAssert(element().isPersistent(), Matchers.is(true), "Dialog is not persistent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not persistent", isAssert = true)
    public DialogAssert notPersistent() {
        jdiAssert(element().isPersistent(), Matchers.is(false), "Dialog is persistent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is scrollable", isAssert = true)
    public DialogAssert scrollable() {
        jdiAssert(element().isScrollable(), Matchers.is(true), "Dialog is not scrollable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not scrollable", isAssert = true)
    public DialogAssert notScrollable() {
        jdiAssert(element().isScrollable(), Matchers.is(false), "Dialog is scrollable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has visible '{0}' in dialog content", isAssert = true)
    public DialogAssert visibleContent(UIElement element) {
        jdiAssert(element().hasVisibleContent(element), Matchers.is(true), "Dialog has no visible content");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not visible '{0}' in dialog content", isAssert = true)
    public DialogAssert notVisibleContent(UIElement element) {
        jdiAssert(element().hasVisibleContent(element), Matchers.is(false), "Dialog has visible content");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has width '{0}'", isAssert = true)
    public DialogAssert maxWidthPx(int width) {
        jdiAssert(element().maxWidthPx(), Matchers.equalTo(width));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has margin '{0} px'", isAssert = true)
    public DialogAssert marginPx(int margin) {
        jdiAssert(element().marginPx(), Matchers.equalTo(margin));
        return this;
    }
}
