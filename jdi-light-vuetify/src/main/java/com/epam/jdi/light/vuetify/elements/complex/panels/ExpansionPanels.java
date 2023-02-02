package com.epam.jdi.light.vuetify.elements.complex.panels;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.panels.ExpansionPanelsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

import java.util.List;

/**
 * To see an example of Expansion Panels web element please visit
 * https://vuetifyjs.com/en/components/expansion-panels/
 */
public class ExpansionPanels extends UIListBase<ExpansionPanelsAssert> implements HasTheme, IsFlat, IsTile {
    private String panelsLocator = ".v-expansion-panel";

    @Override
    public ExpansionPanelsAssert is() {
        return new ExpansionPanelsAssert().set(this);
    }

    @Override
    public WebList list() {
        return finds(panelsLocator).setName(getName() + " expansion panels");
    }

    @JDIAction("Get Panels from '{name}'")
    public List<ExpansionPanel> panels() {
        return list().map(e -> new ExpansionPanel().setCore(ExpansionPanel.class, e));
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return panels().stream()
                .allMatch(ExpansionPanel::isEnabled);
    }

    @JDIAction("Check that '{name}' is accordion")
    public boolean isAccordion() {
        return hasClass("v-expansion-panels--accordion");
    }

    @JDIAction("Check that '{name}' is focusable")
    public boolean isFocusable() {
        return hasClass("v-expansion-panels--focusable");
    }

    @JDIAction("Check that '{name}' is inset")
    public boolean isInset() {
        return hasClass("v-expansion-panels--inset");
    }

    @JDIAction("Check that '{name}' is popout")
    public boolean isPopout() {
        return hasClass("v-expansion-panels--popout");
    }
}

