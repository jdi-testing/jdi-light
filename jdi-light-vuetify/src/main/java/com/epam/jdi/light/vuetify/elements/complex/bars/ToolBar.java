package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.tools.Timer;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    public UIElement getDeleteButton() {
        return this.find(".mdi-delete");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getCloseButton() {
        return this.find(".mdi-close");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getAppsButton() {
        return this.find(".mdi-apps");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getInput() {
        return this.find("input");
    }

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getSelectOptionsField() {
        return this.find(".v-select__selections");
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
    public boolean hasDeleteButton() {
        Timer.waitCondition(getDeleteButton()::isClickable);
        return getDeleteButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasCloseButton() {
        Timer.waitCondition(getCloseButton()::isClickable);
        return getCloseButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasAppsButton() {
        Timer.waitCondition(getAppsButton()::isClickable);
        return getAppsButton().isClickable();
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
    public boolean hasSelectOptionsField() {
        Timer.waitCondition(getSelectOptionsField()::isDisplayed);
        return getSelectOptionsField().isDisplayed();
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
    public String getHeaderColor() {
        return Arrays.stream(getHeader()
                        .getAttribute("class")
                        .split(" "))
                        .map(String::new)
                        .collect(Collectors.toList()).get(3);
    }

    @JDIAction("{name} has icon")
    public boolean isInputFocused() {
        return this.find(".v-input").getAttribute("class").contains("is-focused");
    }

    @JDIAction("{name} has icon")
    public String getSelectedOptions() {
        return this.find("input[type=hidden]").getAttribute("value");
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }

    public ToolBarAssert has() {
        return this.is();
    }

}
