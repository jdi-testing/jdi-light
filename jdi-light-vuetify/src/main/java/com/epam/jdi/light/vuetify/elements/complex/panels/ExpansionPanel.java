package com.epam.jdi.light.vuetify.elements.complex.panels;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ExpansionPanelAssert;

public class ExpansionPanel extends UIBaseElement<ExpansionPanelAssert> {

    protected String OPEN_PANEL_CLASS = "v-expansion-panel--active";
    protected String DISABLED_PANEL_CLASS = "v-expansion-panel--disabled";

    protected String HEADER_LOCATOR = ".v-expansion-panel-header";
    protected String ICON_LOCATOR = ".v-expansion-panel-header__icon";
    protected String CONTENT_LOCATOR = ".v-expansion-panel-content";
    protected String WRAPPER_LOCATOR = ".v-expansion-panel-content__wrap";

    //Access only as part of ExpansionPanels or if you want to create yours custom panel
    protected ExpansionPanel() {}

    @JDIAction("Get icon from '{name}'")
    public UIElement expander() {
        return core().find(ICON_LOCATOR);
    }

    @JDIAction("Get header from '{name}'")
    public UIElement header() {
        return core().find(HEADER_LOCATOR);
    }

    @JDIAction("Get wrapper from '{name}'")
    public UIElement content() {
        expand();
        return core().find(CONTENT_LOCATOR);
    }

    @JDIAction("Get wrapper from '{name}'")
    public UIElement wrapper() {
        expand();
        return core().find(WRAPPER_LOCATOR);
    }

    @JDIAction("Open '{name}'")
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
        return !core().hasClass(DISABLED_PANEL_CLASS);
    }

    @Override
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return !isEnabled();
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return core().hasClass(OPEN_PANEL_CLASS);
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
