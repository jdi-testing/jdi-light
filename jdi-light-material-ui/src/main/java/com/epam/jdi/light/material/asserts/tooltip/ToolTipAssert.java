package com.epam.jdi.light.material.asserts.tooltip;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.tooltip.ToolTip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolTipAssert extends UIAssert<ToolTipAssert, ToolTip> {

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isDefaultDisplayed() {
        jdiAssert(element().addDefaultIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isDeleteDisplayed() {
        jdiAssert(element().deleteDefaultIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isTriggerDisplayed() {
        jdiAssert(element().triggerIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isTriggerNotDisplayed() {
        jdiAssert(!element().triggerIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isInteractiveDisplayed() {
        jdiAssert(element().triggerIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isCustomosedDisplayed() {
        jdiAssert(element().customizedTollTipIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isFadeDisplayed() {
        jdiAssert(element().fadeToolTipIsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ToolTipAssert isPlusDisplayed() {
        jdiAssert(element().plusToolTipIsDisplayed(), Matchers.is(true));
        return this;
    }
}
