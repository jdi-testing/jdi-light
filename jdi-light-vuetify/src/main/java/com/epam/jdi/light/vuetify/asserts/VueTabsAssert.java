package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VueTabs;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VueTabsAssert extends UISelectAssert<VueTabsAssert, VueTabs> implements
        ColorAssert<VueTabsAssert, VueTabs>, ThemeAssert<VueTabsAssert, VueTabs> {

    @Override
    @JDIAction(value = "Assert that '{name}' tab '{0}' is selected", isAssert = true)
    public VueTabsAssert selected(int index) {
        jdiAssert(element().isSelected(index), Matchers.is(true), "Tab is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' is not selected", isAssert = true)
    public VueTabsAssert notSelected(int index) {
        jdiAssert(element().isSelected(index), Matchers.is(false), "Tab is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has size '{0}'", isAssert = true)
    public VueTabsAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }
    @JDIAction(value = "Assert that '{name}' is fixed", isAssert = true)
    public VueTabsAssert fixed() {
        jdiAssert(element().isFixed(), Matchers.is(true), "Tab is not fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is grow", isAssert = true)
    public VueTabsAssert grow() {
        jdiAssert(element().isGrow(), Matchers.is(true), "Tab is not grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not grow", isAssert = true)
    public VueTabsAssert notGrow() {
        jdiAssert(element().isGrow(), Matchers.is(false), "Tab is grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is right", isAssert = true)
    public VueTabsAssert right() {
        jdiAssert(element().isRight(), Matchers.is(true), "Tab is not right");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not right", isAssert = true)
    public VueTabsAssert notRight() {
        jdiAssert(element().isRight(), Matchers.is(false), "Tab is right");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is vertical", isAssert = true)
    public VueTabsAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Tab is not vertical");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not vertical", isAssert = true)
    public VueTabsAssert notVertical() {
        jdiAssert(element().isVertical(), Matchers.is(false), "Tab is vertical");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab with index '{0}' exists", isAssert = true)
    public VueTabsAssert tabExist(int index) {
        jdiAssert(element().get(index).isExist(), Matchers.is(true),
                String.format("Tab with index '%d' doesn't exist", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab with index '{0}' doesn't exist", isAssert = true)
    public VueTabsAssert tabNotExist(int index) {
        jdiAssert(element().get(index).isNotExist(), Matchers.is(true),
                String.format("Tab with index '%d' doesn't exist", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab text content matched condition", isAssert = true)
    public VueTabsAssert tabTextContent(Matcher<String> condition) {
        jdiAssert(element().getTabTextContent(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab text content is '{0}'", isAssert = true)
    public VueTabsAssert tabTextContent(String text) {
        tabTextContent(Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab text content contains '{0}'", isAssert = true)
    public VueTabsAssert tabTextContentContains(String text) {
        tabTextContent(Matchers.containsString(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is align with title", isAssert = true)
    public VueTabsAssert alignWithTitle() {
        jdiAssert(element().isAlignWithTitle(), Matchers.is(true), "Tab is not align with title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not align with title", isAssert = true)
    public VueTabsAssert notAlignWithTitle() {
        jdiAssert(element().isAlignWithTitle(), Matchers.is(false), "Tab is align with title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has tab slider size '{0}'", isAssert = true)
    public VueTabsAssert tabSliderSizePx(int n) {
        jdiAssert(element().tabsSliderSize(), Matchers.equalTo(n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has tab slider color '{0}'", isAssert = true)
    public VueTabsAssert tabSliderColor(String color) {
        jdiAssert(element().tabsSliderColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' is disabled", isAssert = true)
    public VueTabsAssert tabDisabled(int index) {
        jdiAssert(element().isTabDisabled(index), Matchers.is(true),
                String.format("Tab's tab with index '%d' is enabled", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' is enabled", isAssert = true)
    public VueTabsAssert tabEnabled(int index) {
        jdiAssert(element().isTabDisabled(index), Matchers.is(false),
                String.format("Tab's tab with index '%d' is disabled", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' has href", isAssert = true)
    public VueTabsAssert tabHref(int index) {
        jdiAssert(element().tabHasHref(index), Matchers.is(true),
                String.format("Tab's tab with index '%d' has no href", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' has no href", isAssert = true)
    public VueTabsAssert noTabHref(int index) {
        jdiAssert(element().tabHasHref(index), Matchers.is(false),
                String.format("Tab's tab with index '%d' has href", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has tab {0} has href '{1}'", isAssert = true)
    public VueTabsAssert tabHref(int index, String href) {
        jdiAssert(element().getTabHref(index), Matchers.equalTo(href));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shows arrows", isAssert = true)
    public VueTabsAssert showArrows() {
        jdiAssert(element().showsArrows(), Matchers.is(true),
                "Tabs doesn't show arrows");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' doesn't show arrows", isAssert = true)
    public VueTabsAssert notShowArrows() {
        jdiAssert(element().showsArrows(), Matchers.is(false), "Tab shows arrows");
        return this;
    }
}
