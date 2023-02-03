package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static org.hamcrest.Matchers.lessThan;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> implements ThemeAssert<DialogAssert, Dialog> {

    @Override
    public DialogAssert and() {
        return super.and();
    }

    @JDIAction("Assert that '{name}' is opened")
    public DialogAssert opened() {
        waitCondition(() -> element().isOpened());
        jdiAssert(element().isOpened(), Matchers.is(true), "Element is closed");
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public DialogAssert closed() {
        jdiAssert(element().isOpened(), Matchers.is(false), "Element is opened");
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public DialogAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is not active");
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public DialogAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is active");
        return this;
    }

    @JDIAction("Assert that '{name}' is fullscreen")
    public DialogAssert fullscreen() {
        jdiAssert(element().isFullscreen(), Matchers.is(true), "Element is not fullscreen");
        return this;
    }

    @JDIAction("Assert that '{name}' is not fullscreen")
    public DialogAssert notFullscreen() {
        jdiAssert(element().isFullscreen(), Matchers.is(false), "Element is fullscreen");
        return this;
    }

    @JDIAction("Assert that '{name}' is persistent")
    public DialogAssert persistent() {
        jdiAssert(element().isPersistent(), Matchers.is(true), "Element is not persistent");
        return this;
    }

    @JDIAction("Assert that '{name}' is not persistent")
    public DialogAssert notPersistent() {
        jdiAssert(element().isPersistent(), Matchers.is(false), "Element is persistent");
        return this;
    }

    @JDIAction("Assert that '{name}' is scrollable")
    public DialogAssert scrollable() {
        jdiAssert(element().isScrollable(), Matchers.is(true), "Element is not scrollable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not scrollable")
    public DialogAssert notScrollable() {
        jdiAssert(element().isScrollable(), Matchers.is(false), "Element is scrollable");
        return this;
    }

    @JDIAction("Assert that '{name}' has visible '{0}' in dialog content")
    public DialogAssert visibleContent(UIElement element) {
        jdiAssert(element().hasVisibleContent(element), Matchers.is(true), "Element has no visible content");
        return this;
    }

    @JDIAction("Assert that '{name}' has not visible '{0}' in dialog content")
    public DialogAssert notVisibleContent(UIElement element) {
        jdiAssert(element().hasVisibleContent(element), Matchers.is(false), "Element has visible content");
        return this;
    }

    @JDIAction("Assert that '{name}' has width '{0}'")
    public DialogAssert maxWidthPx(int width) {
        int actualWidth = element().maxWidthPx();
        jdiAssert(actualWidth, Matchers.equalTo(width), String.format("Element's actual max-width '%s px' is not " +
                "equal to expected '%s px'", actualWidth, width));
        return this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    public DialogAssert widthPx(int width) {
        int actualWidth = element().getWidthPx();
        jdiAssert(actualWidth, Matchers.is(width), String.format("Element's actual width '%s px' is not " +
                "equal to expected '%s px'", actualWidth, width));
        return this;
    }

    @JDIAction("Assert that '{name}' has margin '{0} px'")
    public DialogAssert marginPx(int margin) {
        int actualMargin = element().marginPx();
        jdiAssert(actualMargin, Matchers.equalTo(margin), String.format("Element's actual margin '%s px' is not " +
                "equal to expected '%s px'", actualMargin, margin));
        return this;
    }

    @JDIAction("Assert that inset '{name}' width is '{0}' of its parent")
    public DialogAssert insetSheetWidthProportion(double widthProportion) {
        double insetWidth = element().dialogWindow().getSize().width;
        int parentWidth = element().getSize().width;
        jdiAssert(Math.abs(insetWidth / parentWidth - widthProportion), lessThan(1e-3));
        return this;
    }

    @JDIAction("Assert that '{name}' is inset")
    public DialogAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Element is not inset");
        return this;
    }

    @JDIAction("Assert that '{name}' is not inset")
    public DialogAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Element is inset");
        return this;
    }

}
