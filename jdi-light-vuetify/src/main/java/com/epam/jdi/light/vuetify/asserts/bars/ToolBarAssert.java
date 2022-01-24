package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBar, ToolBarAssert> {

    @JDIAction("Assert that '{name}'s 'close' and 'delete' buttons are hidden")
    public ToolBarAssert hiddenButtons() {
        jdiAssert(element().hasHiddenButtons() ?
                        "'close' and 'delete' buttons are hidden" : "'close' and 'delete' buttons are visible",
                Matchers.is("'close' and 'delete' buttons are hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' has collapsed header")
    public ToolBarAssert collapsedHeader() {
        jdiAssert(element().hasCollapsedHeader() ? "header is collapsed" : "header is not collapsed",
                Matchers.is("header is collapsed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has dense header")
    public ToolBarAssert denseHeader() {
        jdiAssert(element().hasDenseHeader() ? "header is dense" : "header is not dense",
                Matchers.is("header is dense"));
        return this;
    }

    @JDIAction("Assert that '{name}' has extended header")
    public ToolBarAssert extendedHeader() {
        jdiAssert(element().hasExtendedHeader() ? "header is extended" : "header is not extended",
                Matchers.is("header is extended"));
        return this;
    }

    @JDIAction("Assert that '{name}'s header has expected height")
    public ToolBarAssert heightOfHeader(Integer height) {
        jdiAssert(element().getHeaderHeight(), Matchers.is(String.format("height: %spx;", height)));
        return this;
    }

    @JDIAction("Assert that '{name}'s header has expected color")
    public ToolBarAssert headerColor(String color) {
        Timer.waitCondition(() -> element().getHeaderColor().equals(color));
        jdiAssert(element().getHeaderColor(), Matchers.is(color));
        return this;
    }
}
