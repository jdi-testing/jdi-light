package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyTabs;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyTabsAssert extends UISelectAssert<VuetifyTabsAssert, VuetifyTabs> implements
        ColorAssert<VuetifyTabsAssert, VuetifyTabs>, ThemeAssert<VuetifyTabsAssert, VuetifyTabs> {

    @Override
    @JDIAction(value = "Assert that '{name}' tab '{0}' is selected")
    public VuetifyTabsAssert selected(int index) {
        jdiAssert(element().isSelected(index), Matchers.is(true), "Element is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' is not selected")
    public VuetifyTabsAssert notSelected(int index) {
        jdiAssert(element().isSelected(index), Matchers.is(false), "Element is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has size '{0}'")
    public VuetifyTabsAssert size(int size) {
        int actualSize = element().size();
        jdiAssert(actualSize, Matchers.is(size), String.format("Element's actual size '%s' is not equal to expected " +
                "'%s'", actualSize, size));
        return this;
    }
    @JDIAction(value = "Assert that '{name}' is fixed")
    public VuetifyTabsAssert fixed() {
        jdiAssert(element().isFixed(), Matchers.is(true), "Element is not fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is grow")
    public VuetifyTabsAssert grow() {
        jdiAssert(element().isGrow(), Matchers.is(true), "Element is not grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not grow")
    public VuetifyTabsAssert notGrow() {
        jdiAssert(element().isGrow(), Matchers.is(false), "Element is grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is right")
    public VuetifyTabsAssert right() {
        jdiAssert(element().isRight(), Matchers.is(true), "Element is not right");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not right")
    public VuetifyTabsAssert notRight() {
        jdiAssert(element().isRight(), Matchers.is(false), "Element is right");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is vertical")
    public VuetifyTabsAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Element is not vertical");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not vertical")
    public VuetifyTabsAssert notVertical() {
        jdiAssert(element().isVertical(), Matchers.is(false), "Element is vertical");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab with index '{0}' exists")
    public VuetifyTabsAssert tabExist(int index) {
        jdiAssert(element().get(index).isExist(), Matchers.is(true), String.format("Tab with index '%s' doesn't " +
                "exist", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab with index '{0}' doesn't exist")
    public VuetifyTabsAssert tabNotExist(int index) {
        jdiAssert(element().get(index).isNotExist(), Matchers.is(true), String.format("Tab with index '%s' " +
                "doesn't exist", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab text content is '{0}'")
    public VuetifyTabsAssert tabTextContent(Matcher<String> condition) {
        String actualTabTextContent = element().getTabTextContent();
        jdiAssert(actualTabTextContent, condition, String.format("Element's actual tab text content '%s' is not " +
                "equal to expected '%s'", actualTabTextContent, condition));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab text content is '{0}'")
    public VuetifyTabsAssert tabTextContent(String text) {
        tabTextContent(Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab text content contains '{0}'")
    public VuetifyTabsAssert tabTextContentContaining(String text) {
        tabTextContent(Matchers.containsString(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is align with title")
    public VuetifyTabsAssert alignWithTitle() {
        jdiAssert(element().isAlignWithTitle(), Matchers.is(true), "Element is not align with title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not align with title")
    public VuetifyTabsAssert notAlignWithTitle() {
        jdiAssert(element().isAlignWithTitle(), Matchers.is(false), "Element is align with title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has tab slider size '{0}'")
    public VuetifyTabsAssert tabSliderSizePx(int n) {
        int actualTabSliderSize = element().tabsSliderSize();
        jdiAssert(actualTabSliderSize, Matchers.equalTo(n), String.format("Element's actual tab slider size '%s' is " +
                "not equal to expected '%s'", actualTabSliderSize, n));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has tab slider color '{0}'")
    public VuetifyTabsAssert tabSliderColor(String color) {
        String actualTabSliderColor = element().tabsSliderColor();
        jdiAssert(actualTabSliderColor, Matchers.equalTo(color), String.format("Element's actual tab slider color " +
                "'%s' is not equal to expected '%s'", actualTabSliderColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' is disabled")
    public VuetifyTabsAssert tabDisabled(int index) {
        jdiAssert(element().isTabDisabled(index), Matchers.is(true), String.format("Element's tab '%s' is enabled",
                index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' is enabled")
    public VuetifyTabsAssert tabEnabled(int index) {
        jdiAssert(element().isTabDisabled(index), Matchers.is(false), String.format("Element's tab '%s' is " +
                "disabled", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' has href")
    public VuetifyTabsAssert tabHref(int index) {
        jdiAssert(element().tabHasHref(index), Matchers.is(true), String.format("Element's tab '%s' has no href",
                index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' tab '{0}' has no href")
    public VuetifyTabsAssert noTabHref(int index) {
        jdiAssert(element().tabHasHref(index), Matchers.is(false), String.format("Element's tab '%s' has href",
                index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has tab slider color '{0}'")
    public VuetifyTabsAssert tabHref(int index, String href) {
        String actualTabHref = element().getTabHref(index);
        jdiAssert(actualTabHref, Matchers.equalTo(href), String.format("Element's actual tab '%s' href '%s' is not " +
                "equal to expected '%s'", index, actualTabHref, href));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shows arrows")
    public VuetifyTabsAssert showArrows() {
        jdiAssert(element().showsArrows(), Matchers.is(true), "Element's tab '%s' has no href");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' doesn't show arrows")
    public VuetifyTabsAssert notShowArrows() {
        jdiAssert(element().showsArrows(), Matchers.is(false), "Element shows arrows");
        return this;
    }
}
