package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.tools.Timer;

/**
 * To see examples of Tool Bars web elements please visit https://vuetifyjs.com/en/components/toolbars
 *
 * The v-toolbar component is pivotal to any gui, as it generally is the primary source of site navigation.
 * The toolbar component works great in conjunction with v-navigation-drawer and v-card.
 *
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {

    @JDIAction("Get '{name}' title")
    public UIElement getBackgroundImage() {
        return this.find(".v-image__image");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getExportButton() {
        return this.find(".mdi-menu");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getMapImage() {
        return this.find(".v-card--flat");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getGpsButton() {
        return this.find(".mdi-crosshairs-gps");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getInput() {
        return this.find("input");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getTabs() {
        return this.finds(".v-tab");
    }

    @JDIAction("Get '{name}' text field")
    public UIElement getNavigationMenu() {
        return this.find(".v-navigation-drawer__content");
    }

    @JDIAction("{name} has icon")
    public boolean hasBackgroundImage() {
        Timer.waitCondition(getBackgroundImage()::isDisplayed);
        return getBackgroundImage().getAttribute("style").contains("url");
    }

    @JDIAction("{name} has icon")
    public boolean hasExportButton() {
        Timer.waitCondition(getExportButton()::isDisplayed);
        return getExportButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasGpsButton() {
        Timer.waitCondition(getGpsButton()::isClickable);
        return getGpsButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasInput() {
        Timer.waitCondition(getInput()::isDisplayed);
        return getInput().isVisible();
    }

    @JDIAction("{name} has icon")
    public boolean hasMapImage() {
        Timer.waitCondition(getMapImage()::isDisplayed);
        return getMapImage().getAttribute("style").contains("url");
    }

        @JDIAction("{name} has icon")
    public boolean isCollapsed() {
        return getHeader().getAttribute("class").contains("collapsed");
    }

    @JDIAction("{name} has icon")
    public boolean isDense() {
        return getHeader().getAttribute("class").contains("dense");
    }

    @JDIAction("{name} has icon")
    public boolean isExtended() {
        return getHeader().getAttribute("class").contains("extended");
    }

    @JDIAction("{name} has icon")
    public boolean getHeight(String height) {
        return getHeader().getAttribute("style").equals(String.format("height: %spx;",height));
    }

    @JDIAction("{name} has icon")
    public boolean isInputFocused() {
        return this.find(".v-input").getAttribute("class").contains("is-focused");
    }

    @JDIAction("{name} has icon")
    public boolean hasTabs() {
        Timer.waitCondition(this.getTabs()::isDisplayed);
        return getTabs().size() > 1;
    }

    @JDIAction("{name} has navigation menu")
    public boolean hasNavigationMenu() {
        Timer.waitCondition(this.getNavigationMenu()::isDisplayed);
        return getNavigationMenu().isDisplayed();
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }

    public ToolBarAssert has() {
        return this.is();
    }

}
