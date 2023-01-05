package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.lessThan;

public class BottomSheetAssert extends UIAssert<BottomSheetAssert, BottomSheet> implements
        ThemeAssert<BottomSheetAssert, BottomSheet> {
    @JDIAction("Assert that option titles are presented")
    public BottomSheetAssert optionTitlesPresented(String optionName) {
        jdiAssert(element().isOptionTitlesPresented(optionName) ? "option title is presented"
                : "option title is not presented", Matchers.is("option title is presented"));
        return this;
    }

    @JDIAction("Assert that inset '{name}' width is '{0}' of its parent")
    public BottomSheetAssert insetSheetWidthProportion(double widthProportion) {
        double insetWidth = element().find(".v-dialog").getSize().width;
        int parentWidth = element().getSize().width;
        jdiAssert(Math.abs(insetWidth / parentWidth - widthProportion), lessThan(1e-3));
        return this;
    }

    @JDIAction("Assert that '{name}' is persistent")
    public BottomSheetAssert persistent() {
        jdiAssert(element().isPersistent(), Matchers.is(true), "Element is not persistent");
        return this;
    }

    @JDIAction("Assert that '{name}' is not persistent")
    public BottomSheetAssert notPersistent() {
        jdiAssert(element().isPersistent(), Matchers.is(false), "Element is persistent");
        return this;
    }

    @JDIAction("Assert that '{name}' is fullscreen")
    public BottomSheetAssert fullscreen() {
        jdiAssert(element().isFullscreen(), Matchers.is(true), "Element is not fullscreen");
        return this;
    }

    @JDIAction("Assert that '{name}' is not fullscreen")
    public BottomSheetAssert notFullscreen() {
        jdiAssert(element().isFullscreen(), Matchers.is(false), "Element is fullscreen");
        return this;
    }

    @JDIAction("Assert that '{name}' is scrollable")
    public BottomSheetAssert scrollable() {
        jdiAssert(element().isScrollable(), Matchers.is(true), "Element is not scrollable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not scrollable")
    public BottomSheetAssert notScrollable() {
        jdiAssert(element().isScrollable(), Matchers.is(false), "Element is scrollable");
        return this;
    }

    @JDIAction("Assert that '{name}' is inset")
    public BottomSheetAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Element is not inset");
        return this;
    }

    @JDIAction("Assert that '{name}' is not inset")
    public BottomSheetAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Element is inset");
        return this;
    }

    @JDIAction("Assert that '{name}' max-width is '{0}'")
    public BottomSheetAssert maxWidthPx(int maxWidth) {
        int actualMaxWidth = element().getMaxWidthPx();
        jdiAssert(actualMaxWidth, Matchers.is(maxWidth), String.format("Element's actual max-width '%s px' is not " +
                "equal to expected '%s px'", actualMaxWidth, maxWidth));
        return this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    public BottomSheetAssert widthPx(int width) {
        int actualWidth = element().getWidthPx();
        jdiAssert(actualWidth, Matchers.is(width), String.format("Element's actual width '%s px' is not " +
                "equal to expected '%s px'", actualWidth, width));
        return this;
    }
}
