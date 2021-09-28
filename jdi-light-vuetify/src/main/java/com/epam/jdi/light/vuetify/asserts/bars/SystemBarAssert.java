package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SystemBarAssert extends BasicBarAssert<SystemBar, SystemBarAssert> {

    @JDIAction("Assert that banner has proper title")
    public SystemBarAssert headerShadowHidden(String text) {
        jdiAssert(element().getHeaderStatus(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public SystemBarAssert headerShadowVisible(String text) {
        jdiAssert(element().getHeaderStatus(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public SystemBarAssert headerHeight(String text) {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("height: " + text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public SystemBarAssert headerVisible() {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("transform: translateY(0px)"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public SystemBarAssert headerHidden() {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("transform: translateY(-128px)"));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public SystemBarAssert hiddenTitle() {
        jdiAssert(element().hasHiddenTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public SystemBarAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }
}
