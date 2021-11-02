package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert  extends BasicBarAssert<AppBar, AppBarAssert> {

    @JDIAction("Assert that '{name}' has tabs")
    public AppBarAssert clickableTabs() throws Exception {
        jdiAssert(element().hasClickableTabs() ? "has tabs" : "does not have tabs", Matchers.is("has tabs"));
        return this;
    }

    @JDIAction("Assert that '{name}' has navigation menu")
    public AppBarAssert navigationMenu() {
        jdiAssert(element().hasNavigationMenu() ? "has navigation menu" : "does not have navigation menu",
                Matchers.is("has navigation menu"));
        return this;
    }

    @JDIAction("Assert that '{name}' has visible header")
    public AppBarAssert visibleHeader() {
        jdiAssert(element().hasVisibleHeader() ? "has visible header" : "does not have visible header",
                Matchers.is("has visible header"));
        return this;
    }

    @JDIAction("Assert that '{name}' has hidden header")
    public AppBarAssert hiddenHeader() {
        jdiAssert(element().hasHiddenHeader() ? "has hidden header" : "has visible header",
                Matchers.is("has hidden header"));
        return this;
    }

    @JDIAction("Assert that '{name}' header's shadow is hidden")
    public AppBarAssert hiddenHeaderShadow() {
        jdiAssert(element().hasHiddenHeaderShadow() ? "header's shadow is hidden" : "header's shadow is visible",
                Matchers.is("header's shadow is hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' header's shadow is visible")
    public AppBarAssert visibleHeaderShadow() {
        jdiAssert(element().hasVisibleHeaderShadow() ? "header's shadow is visible" : "header's shadow is hidden",
                Matchers.is("header's shadow is visible"));
        return this;
    }

    @JDIAction("Assert that '{name}' header has expected height")
    public AppBarAssert headerHeight(String text) {
        jdiAssert(element().hasHeaderHeight(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' header has expected opacity")
    public AppBarAssert headerOpacity(Integer opacity) {
        jdiAssert(element().hasHeaderOpacity(), Matchers.equalTo(opacity));
        return this;
    }

    @JDIAction("Assert that '{name}' title is hidden")
    public AppBarAssert hiddenTitle() {
        jdiAssert(element().hasHiddenTitle() ? "has hidden title" : "has visible title",
                Matchers.is("has hidden title"));
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox")
    public AppBarAssert checkbox() {
        jdiAssert(element().hasCheckbox() ? "checkbox is displayed" : "checkbox is not displayed",
                Matchers.is("checkbox is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' checkbox is checked")
    public AppBarAssert checkboxChecked() {
        jdiAssert(element().checkboxChecked() ? "checkbox is checked" : "checkbox is unchecked",
                Matchers.is("checkbox is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' checkbox is unchecked")
    public AppBarAssert checkboxUnchecked() {
        jdiAssert(element().checkboxUnchecked() ? "checkbox is unchecked" : "checkbox is checked",
                Matchers.is("checkbox is unchecked"));
        return this;
    }
}
