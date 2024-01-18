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
    @JDIAction(value = "Assert that '{name}' is accordion", isAssert = true)
    public ExpansionPanelsAssert accordion() {
        jdiAssert(element().isAccordion(), Matchers.is(true), "ExpansionPanel is not accordion");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not accordion", isAssert = true)
    public ExpansionPanelsAssert notAccordion() {
        jdiAssert(element().isAccordion(), Matchers.is(false), "ExpansionPanel is accordion");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is focusable", isAssert = true)
    public ExpansionPanelsAssert focusable() {
        jdiAssert(element().isFocusable(), Matchers.is(true), "ExpansionPanel is not focusable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not focusable", isAssert = true)
    public ExpansionPanelsAssert notFocusable() {
        jdiAssert(element().isFocusable(), Matchers.is(false), "ExpansionPanel is focusable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is inset", isAssert = true)
    public ExpansionPanelsAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "ExpansionPanel is not inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not inset", isAssert = true)
    public ExpansionPanelsAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "ExpansionPanel is inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is popout", isAssert = true)
    public ExpansionPanelsAssert popout() {
        jdiAssert(element().isPopout(), Matchers.is(true), "ExpansionPanel is not popout");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not popout", isAssert = true)
    public ExpansionPanelsAssert notPopout() {
        jdiAssert(element().isPopout(), Matchers.is(false), "ExpansionPanel is popout");
        return this;
    }
}
