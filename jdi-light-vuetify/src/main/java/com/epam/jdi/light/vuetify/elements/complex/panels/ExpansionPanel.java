package com.epam.jdi.light.vuetify.elements.complex.panels;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.panels.ExpansionPanelAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.HasColor;

public class ExpansionPanel extends UIBaseElement<ExpansionPanelAssert> implements HasColor {

    protected static final String OPEN_PANEL_CLASS = "v-expansion-panel--active";
    protected static final String DISABLED_PANEL_CLASS = "v-expansion-panel--disabled";
    private String iconLocator = ".v-expansion-panel-header__icon .v-icon";
    private String headerIconLocator = ".v-expansion-panel-header__icon";
    private String contentLocator = ".v-expansion-panel-content";
    private String headerLocator = ".v-expansion-panel-header";

    //Access only as part of ExpansionPanels or if you want to create yours custom panel
    protected ExpansionPanel() {}

    @JDIAction("Get '{name}' header")
    public UIElement header() {
        return find(headerLocator);
    }

    @JDIAction("Get '{name}' header icon")
    public UIElement headerIcon() {
        return find(headerIconLocator);
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

    @Override
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return hasClass(DISABLED_PANEL_CLASS);
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

    public void setHeaderLocator(String headerLocator) {
        this.headerLocator = headerLocator;
    }

    public void setHeaderIconLocator(String headerIconLocator) {
        this.headerIconLocator = headerIconLocator;
    }

    public void setIconLocator(String iconLocator) {
        this.iconLocator = iconLocator;
    }

    public void setContentLocator(String contentLocator) {
        this.contentLocator = contentLocator;
    }

    @Override
    @JDIAction("Get '{name}' header font color")
    public String color() {
        return header().css("color");
    }

    @Override
    @JDIAction("Get '{name}' header background color")
    public String backgroundColor() {
        return header().css("background-color");
    }

    @JDIAction("Get '{name}' header font color")
    public String contentColor() {
        return content().css("color");
    }

    @JDIAction("Get '{name}' content background color")
    public String contentBackgroundColor() {
        return content().css("background-color");
    }

    @JDIAction("check that '{name}' header has icon disable rotate")
    public boolean hasIconDisableRotate() {
        return headerIcon().hasClass("v-expansion-panel-header__icon--disable-rotate");
    }
}
