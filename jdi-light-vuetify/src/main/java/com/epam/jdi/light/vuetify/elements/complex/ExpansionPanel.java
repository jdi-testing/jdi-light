package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.vuetify.asserts.ExpansionPanelAssert;

/**
 * To see an example of Expansion Panels web element please visit
 * https://jdi-testing.github.io/jdi-light/vuetify/expansion-panels
 */
public class ExpansionPanel extends UIBaseElement<ExpansionPanelAssert> {

    @UI(".v-expansion-panel-header")
    protected Button header;

    @UI(".v-expansion-panel-header__icon")
    protected Icon icon;

    @UI(".v-expansion-panel-content__wrap")
    protected UIElement wrapper;

    @JDIAction("Get icon in '{name}'")
    public Icon getIcon() {
        return icon;
    }

    @JDIAction("Get header in '{name}'")
    public Button getHeader() {
        return header;
    }

    @JDIAction("Get wrapper in '{name}'")
    public UIElement getWrapper() {
        if (isClosed()) {
            open();
        }
        return wrapper;
    }

    @JDIAction("Open content in '{name}'")
    public void open() {
        if (isClosed()) {
            icon.click();
        }
    }

    @JDIAction("Close content in '{name}'")
    public void close() {
        if (isOpen()) {
            icon.click();
        }
    }

    @Override
    public boolean isEnabled() {
        return !core().hasClass("v-expansion-panel--disabled");
    }

    @Override
    public boolean isDisabled() {
        return !isEnabled();
    }

    @JDIAction("Check that '{name}' is open")
    public boolean isOpen() {
        return core().hasClass("v-expansion-panel--active");
    }

    @JDIAction("Check that '{name}' is closed")
    public boolean isClosed() {
        return !isOpen();
    }

    public ExpansionPanelAssert is() {
        return new ExpansionPanelAssert().set(this);
    }

    public ExpansionPanelAssert has() {
        return is();
    }
}

