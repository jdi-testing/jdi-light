package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.android.TabBar;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TabBarAssert extends UIAssert<TabBarAssert, TabBar>
        implements ITextAssert<TabBarAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public TabBarAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    public TabBarAssert text(String text) { return text(Matchers.is(text)); }

    @JDIAction("Assert that '{name}' is selected")
    public TabBarAssert selected(String tab) {
        jdiAssert(element.get().isSelected(), Matchers.is(tab));
        return this;
    }

}
