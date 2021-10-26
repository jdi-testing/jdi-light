package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;

/**
 * To see examples of Tool Bar web elements please visit https://vuetifyjs.com/en/components/toolbars
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {

    @JDIAction("Get '{name}' 'close' button")
    private Button getCloseButton() {
        return findIconButton("mdi-close");
    }

    @JDIAction("Get '{name}' 'delete' button")
    private Button getDeleteButton() {
        return findIconButton("mdi-delete");
    }

    @JDIAction("Get '{name}' input field")
    private UIElement getInput() {
        return find("input");
    }

    @JDIAction("Get '{name}' 'select options' field")
    private UIElement getSelectOptionsField() {
        return find(".v-select__selections");
    }

    @JDIAction("'{name}' has header height")
    public boolean hasHeaderHeight(String height) {
        return getHeader().getAttribute("style").equals(String.format("height: %spx;", height));
    }

    @JDIAction("'{name}' header has color")
    public String hasHeaderColor() {
        return getHeader().getCssValue("background-color");
    }

    @JDIAction("'{name}' has selected options")
    public String hasSelectedOptions() {
        return find("input[type=hidden]").getAttribute("value");
    }

    @JDIAction("'{name}' has background image")
    public boolean hasBackgroundImage() {
        return find(".v-image__image").getAttribute("style").contains("url");
    }

    @JDIAction("'{name}' has 'export' button")
    public boolean hasExportButton() {
        Button exportButton = findIconButton("mdi-export");
        return exportButton.isDisplayed();
    }

    @JDIAction("'{name}' has 'search' icon")
    public boolean hasSearchIcon() {
        return castToIcon(find(".mdi-magnify")).isDisplayed();
    }

    @JDIAction("'{name}' has 'GPS' button")
    public boolean hasGpsButton() {
        Button gpsButton = findIconButton("mdi-crosshairs-gps");
        return gpsButton.isDisplayed();
    }

    @JDIAction("'{name}' has 'delete' button")
    public boolean hasDeleteButton() {
        return getDeleteButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'close' button")
    public boolean hasCloseButton() {
        return getCloseButton().isDisplayed();
    }

    @JDIAction("'{name}' has 'apps' button")
    public boolean hasAppsButton() {
        Button appsButton = findIconButton("mdi-apps");
        return appsButton.isDisplayed();
    }

    @JDIAction("'{name}' has input field")
    public boolean hasInput() {
        return getInput().isVisible();
    }

    @JDIAction("'{name}' has 'map' image")
    public boolean hasMapImage() {
        return find(".v-card--flat").getAttribute("style").contains("url");
    }

    @JDIAction("'{name}' has 'select options' field")
    public boolean hasSelectOptionsField() {
        return getSelectOptionsField().isDisplayed();
    }

    @JDIAction("'{name}'s 'delete' and 'close' buttons are hidden")
    public boolean hasHiddenButtons() {
        return getCloseButton().isNotExist() && getDeleteButton().isNotExist();
    }

    @JDIAction("'{name}' header is collapsed")
    public boolean isCollapsed() {
        return getHeader().getAttribute("class").contains("collapsed");
    }

    @JDIAction("'{name}' header is dense")
    public boolean isDense() {
        return getHeader().getAttribute("class").contains("dense");
    }

    @JDIAction("'{name}' header is extended")
    public boolean isExtended() {
        return getHeader().getAttribute("class").contains("extended");
    }

    @JDIAction("'{name}' input field is focused")
    public boolean inputIsFocused() {
        return find(".v-input").getAttribute("class").contains("is-focused");
    }

    public void sendTextToInputField(String text) {
        getInput().select();
        getInput().sendKeys(text);
    }

    public void clickOnSelectOptionsField() {
        getSelectOptionsField().click();
    }

    public void clickOnCloseButton() {
        getCloseButton().click();
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }

    public ToolBarAssert has() {
        return is();
    }
}
