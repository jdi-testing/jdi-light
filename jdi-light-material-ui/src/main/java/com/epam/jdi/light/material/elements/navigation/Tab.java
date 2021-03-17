package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.TabAssert;

public class Tab extends UIBaseElement<TabAssert> {

    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final String TAB_PATTERN = "//button[contains(@class, 'MuiTab-root')]";
    private static final String TAB_WITH_TEXT_PATTERN = TAB_PATTERN.concat("[span[contains(text(), '%s')]]");
    private static final String SCROLL_BUTTON_PATTERN = "//div[contains(@class, 'MuiTabScrollButton-root')]";


    private UIElement getTabByIndex(int index) {
        return core().finds(TAB_PATTERN).get(index);
    }

    private UIElement getTabByText(String text) {
        return core().find(String.format(TAB_WITH_TEXT_PATTERN, text));
    }

    private UIElement getBackScrollButton() {
        return core().finds(SCROLL_BUTTON_PATTERN).get(LEFT);
    }

    private UIElement getForwardScrollButton() {
        return core().finds(SCROLL_BUTTON_PATTERN).get(RIGHT);
    }

    @JDIAction("Select by '{name}'")
    public void selectTab(int index) {
        getTabByIndex(index).click();
    }

    @JDIAction("Select by '{name}'")
    public void selectTab(String text) {
        getTabByText(text).click();
    }

    @JDIAction("Scroll forward")
    public void scrollForward() {
        getForwardScrollButton().click();
    }

    @JDIAction("Scroll back")
    public void scrollBack() {
        getBackScrollButton().click();
    }

    @JDIAction("Is '{name}' enabled")
    public Boolean isTabEnabled(int index) {
        return getTabByIndex(index).isEnabled();
    }

    @JDIAction("Is '{name}' disabled")
    public Boolean isTabDisabled(int index) {
        return getTabByIndex(index).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    public Boolean isTabEnabled(String text) {
        return getTabByText(text).isEnabled();
    }

    @JDIAction("Is '{name}' disabled")
    public Boolean isTabDisabled(String text) {
        return getTabByText(text).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' selected")
    public Boolean isTabSelected(int index) {
        return getTabByIndex(index).hasClass("Mui-selected");
    }

    @JDIAction("Is '{name}' selected")
    public Boolean isTabSelected(String text) {
        return getTabByText(text).hasClass("Mui-selected");
    }

    @JDIAction("Is '{name}' enabled")
    public Boolean isBackScrollButtonEnabled() {
        return getBackScrollButton().isDisplayed() && getBackScrollButton().isEnabled();
    }

    @JDIAction("Is '{name}' disabled")
    public Boolean isBackScrollButtonDisabled() {
        return getBackScrollButton().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    public Boolean isForwardScrollButtonEnabled() {
        return getForwardScrollButton().isDisplayed() && getForwardScrollButton().isEnabled();
    }

    @JDIAction("Is '{name}' disabled")
    public Boolean isForwardScrollButtonDisabled() {
        return getForwardScrollButton().hasClass("Mui-disabled");
    }

    @Override
    public TabAssert is() {
        return new TabAssert().set(this);
    }

}
