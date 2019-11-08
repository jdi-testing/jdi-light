package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Tooltip;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssertUtils.jdiAssert;
import static org.hamcrest.Matchers.is;

public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> implements ITextAssert<TooltipAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public TooltipAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' is hidden")
    public TooltipAssert hidden() {
        jdiAssert(getIsVisible(), is("hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' is visible")
    public TooltipAssert isVisible() {
        jdiAssert(getIsVisible(), is("visible"));
        return this;
    }

    private String getIsVisible() {
        return element.core().hasAttribute("aria-describedby") ? "visible" : "hidden";
    }
}
