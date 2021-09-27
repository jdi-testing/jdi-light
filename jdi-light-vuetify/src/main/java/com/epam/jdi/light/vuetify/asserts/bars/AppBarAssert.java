package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert  extends BasicBarAssert<AppBar, AppBarAssert> {

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert tabs() {
        for(UIElement tab: element().getTabs()) {
            jdiAssert(tab.isClickable(), Matchers.is(true));
        }
        jdiAssert(element().hasTabs(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert navigationMenu() {
        jdiAssert(element().hasNavigationMenu(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerShadowHidden(String text) {
        jdiAssert(element().getHeaderStatus(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerShadowVisible(String text) {
        jdiAssert(element().getHeaderStatus(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerHeight(String text) {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("height: " + text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerVisible() {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("transform: translateY(0px)"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerHidden() {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("transform: translateY(-128px)"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerOpacity(Integer opacity) {
        jdiAssert(element().getHeaderOpacity(), Matchers.containsString("opacity: " + opacity));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert hiddenTitle() {
        jdiAssert(element().hasHiddenTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public AppBarAssert checkerChecked() {
        jdiAssert(element().getCheckerStatus(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is unchecked")
    public AppBarAssert checkerUnchecked() {
        jdiAssert(element().getCheckerStatus(), Matchers.is("false"));
        return this;
    }
}
