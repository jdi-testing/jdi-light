package com.epam.jdi.light.vuetify.asserts.panels;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpansionPanelsAssert extends UISelectAssert<ExpansionPanelsAssert, ExpansionPanels> implements
        ThemeAssert<ExpansionPanelsAssert, ExpansionPanels>, FlatAssert<ExpansionPanelsAssert, ExpansionPanels>,
        TileAssert<ExpansionPanelsAssert, ExpansionPanels> {
    @JDIAction("Assert that '{name}' is accordion")
    public ExpansionPanelsAssert accordion() {
        jdiAssert(element().isAccordion(), Matchers.is(true), "Element is not accordion");
        return this;
    }

    @JDIAction("Assert that '{name}' is not accordion")
    public ExpansionPanelsAssert notAccordion() {
        jdiAssert(element().isAccordion(), Matchers.is(false), "Element is accordion");
        return this;
    }

    @JDIAction("Assert that '{name}' is focusable")
    public ExpansionPanelsAssert focusable() {
        jdiAssert(element().isFocusable(), Matchers.is(true), "Element is not focusable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not focusable")
    public ExpansionPanelsAssert notFocusable() {
        jdiAssert(element().isFocusable(), Matchers.is(false), "Element is focusable");
        return this;
    }

    @JDIAction("Assert that '{name}' is inset")
    public ExpansionPanelsAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Element is not inset");
        return this;
    }

    @JDIAction("Assert that '{name}' is not inset")
    public ExpansionPanelsAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Element is inset");
        return this;
    }

    @JDIAction("Assert that '{name}' is popout")
    public ExpansionPanelsAssert popout() {
        jdiAssert(element().isPopout(), Matchers.is(true), "Element is not popout");
        return this;
    }

    @JDIAction("Assert that '{name}' is not popout")
    public ExpansionPanelsAssert notPopout() {
        jdiAssert(element().isPopout(), Matchers.is(false), "Element is popout");
        return this;
    }
}
