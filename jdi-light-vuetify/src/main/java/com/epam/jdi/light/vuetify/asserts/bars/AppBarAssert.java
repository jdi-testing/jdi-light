package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert  extends BasicBarAssert<AppBar, AppBarAssert> {

    @JDIAction("Assert that {name} has tabs")
    public AppBarAssert clickableTabs() throws Exception {
        jdiAssert(element().hasClickableTabs(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has navigation menu")
    public AppBarAssert navigationMenu() {
        jdiAssert(element().hasNavigationMenu(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has visible header")
    public AppBarAssert visibleHeader() {
        Timer.waitCondition(element()::hasVisibleHeader);
        jdiAssert(element().hasVisibleHeader(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has hidden header")
    public AppBarAssert hiddenHeader() {
        Timer.waitCondition(element()::hasHiddenHeader);
        jdiAssert(element().hasHiddenHeader(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header's shadow is hidden")
    public AppBarAssert hiddenHeaderShadow() {
        Timer.waitCondition(element()::hasHiddenHeaderShadow);
        jdiAssert(element().hasHiddenHeaderShadow(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header's shadow is visible")
    public AppBarAssert visibleHeaderShadow() {
        Timer.waitCondition(element()::hasVisibleHeaderShadow);
        jdiAssert(element().hasVisibleHeaderShadow(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header has proper height")
    public AppBarAssert headerHeight(String text) {
        jdiAssert(element().hasHeaderHeight(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that {name} header has proper opacity")
    public AppBarAssert headerOpacity(Integer opacity) {
        jdiAssert(element().hasHeaderOpacity(), Matchers.equalTo(opacity));
        return this;
    }

    @JDIAction("Assert that {name} title is hidden")
    public AppBarAssert hiddenTitle() {
        jdiAssert(element().hasHiddenTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has checker")
    public AppBarAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} checker is checked")
    public AppBarAssert checkerChecked() {
        jdiAssert(element().checkerChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} checker is unchecked")
    public AppBarAssert checkerUnchecked() {
        jdiAssert(element().checkerUnchecked(), Matchers.is(true));
        return this;
    }
}
