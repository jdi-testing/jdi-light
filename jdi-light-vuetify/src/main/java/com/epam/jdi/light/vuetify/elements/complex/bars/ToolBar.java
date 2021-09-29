package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;

/**
 * To see examples of Tool Bar web elements please visit https://vuetifyjs.com/en/components/toolbars
 *
 * The v-toolbar component is pivotal to any gui, as it generally is the primary source of site navigation.
 * The toolbar component works great in conjunction with v-navigation-drawer and v-card.
 *
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {

    @JDIAction("Get '{name}' background image")
    public UIElement getBackgroundImage() {
        return this.find(".v-image__image");
    }

    @JDIAction("Get '{name}' 'export' button")
    public UIElement getExportButton() {
        return this.find(".mdi-menu");
    }

    @JDIAction("Get '{name}' map image")
    public UIElement getMapImage() {
        return this.find(".v-card--flat");
    }

    @JDIAction("Get '{name}' 'GPS' button")
    public UIElement getGpsButton() {
        return this.find(".mdi-crosshairs-gps");
    }

    @JDIAction("Get '{name}' 'delete' button")
    public UIElement getDeleteButton() {
        return this.find(".mdi-delete");
    }

    @JDIAction("Get '{name}' 'close' button")
    public UIElement getCloseButton() {
        return this.find(".mdi-close");
    }

    @JDIAction("Get '{name}' 'apps' button")
    public UIElement getAppsButton() {
        return this.find(".mdi-apps");
    }

    @JDIAction("Get '{name}' input field")
    public UIElement getInput() {
        return this.find("input");
    }

    @JDIAction("Get '{name}' 'select options' field")
    public UIElement getSelectOptionsField() {
        return this.find(".v-select__selections");
    }

    @JDIAction("Get {name} header height")
    public boolean getHeaderHeight(String height) {
        return getHeader().getAttribute("style").equals(String.format("height: %spx;",height));
    }

    @JDIAction("Get {name} header color")
    public String getHeaderColor() {
        return getHeader().getCssValue("background-color");
    }

    @JDIAction("Get {name} selected options")
    public String getSelectedOptions() {
        return this.find("input[type=hidden]").getAttribute("value");
    }

    @JDIAction("{name} has background image")
    public boolean hasBackgroundImage() {
        Timer.waitCondition(getBackgroundImage()::isDisplayed);
        return getBackgroundImage().getAttribute("style").contains("url");
    }

    @JDIAction("{name} has 'export' button")
    public boolean hasExportButton() {
        Timer.waitCondition(getExportButton()::isDisplayed);
        return getExportButton().isClickable();
    }

    @JDIAction("{name} has 'GPS' button")
    public boolean hasGpsButton() {
        Timer.waitCondition(getGpsButton()::isClickable);
        return getGpsButton().isClickable();
    }

    @JDIAction("{name} has 'delete' button")
    public boolean hasDeleteButton() {
        Timer.waitCondition(getDeleteButton()::isClickable);
        return getDeleteButton().isClickable();
    }

    @JDIAction("{name} has 'close' button")
    public boolean hasCloseButton() {
        Timer.waitCondition(getCloseButton()::isClickable);
        return getCloseButton().isClickable();
    }

    @JDIAction("{name} has 'apps' button")
    public boolean hasAppsButton() {
        Timer.waitCondition(getAppsButton()::isClickable);
        return getAppsButton().isClickable();
    }

    @JDIAction("{name} has input field")
    public boolean hasInput() {
        Timer.waitCondition(getInput()::isDisplayed);
        return getInput().isVisible();
    }

    @JDIAction("{name} has 'map' image")
    public boolean hasMapImage() {
        Timer.waitCondition(getMapImage()::isDisplayed);
        return getMapImage().getAttribute("style").contains("url");
    }

    @JDIAction("{name} has 'select options' field")
    public boolean hasSelectOptionsField() {
        Timer.waitCondition(getSelectOptionsField()::isDisplayed);
        return getSelectOptionsField().isDisplayed();
    }

    @JDIAction("{name} header is collapsed")
    public boolean isCollapsed() {
        return getHeader().getAttribute("class").contains("collapsed");
    }

    @JDIAction("{name} header is dense")
    public boolean isDense() {
        return getHeader().getAttribute("class").contains("dense");
    }

    @JDIAction("{name} header is extended")
    public boolean isExtended() {
        return getHeader().getAttribute("class").contains("extended");
    }

    @JDIAction("{name} header is purple")
    public boolean isPurple() {
        return getHeaderColor().equals(DEEP_PURPLE_ACCENT_4.value());
    }

    @JDIAction("{name} input field is focused")
    public boolean isInputFocused() {
        return this.find(".v-input").getAttribute("class").contains("is-focused");
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }

    public ToolBarAssert has() {
        return this.is();
    }
}
