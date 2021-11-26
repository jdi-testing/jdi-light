package com.epam.jdi.light.vuetify.elements.complex.panels;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ExpansionPanelAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

public class ExpansionPanel extends UIBaseElement<ExpansionPanelAssert> {

    protected static final String OPEN_PANEL_CLASS = "v-expansion-panel--active";
    protected static final String DISABLED_PANEL_CLASS = "v-expansion-panel--disabled";

    protected String headerLocator = ".v-expansion-panel-header";
    protected String iconLocator = ".v-expansion-panel-header__icon .v-icon";
    protected String contentLocator = ".v-expansion-panel-content";

    //Access only as part of ExpansionPanels or if you want to create yours custom panel
    protected ExpansionPanel() {}

    @JDIAction("Get '{name}' header")
    public UIElement header() {
        return find(headerLocator);
    }

    @JDIAction("Get '{name}' expander icon")
    public Icon expander() {
        return new Icon().setCore(Icon.class, find(iconLocator));
    }

    @JDIAction("Get '{name}' content")
    public UIElement content() {
        expand();
        return find(contentLocator);
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (isClosed()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !hasClass(DISABLED_PANEL_CLASS);
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return hasClass(OPEN_PANEL_CLASS);
    }

    @JDIAction("Check that '{name}' is closed")
    public boolean isClosed() {
        return !isExpanded();
    }

    @Override
    public ExpansionPanelAssert is() {
        return new ExpansionPanelAssert().set(this);
    }
}
