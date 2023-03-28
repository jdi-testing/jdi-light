package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.ios.TextField;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;
import static com.epam.jdi.light.mobile.elements.init.MobileAppFactory.$;

public class SearchBar extends TextField {
    private Object pageObject = this;

    @JDIAction(value = "Perform tap on '{name}' Clear button")
    public void tapClearButton() {
        HasTouchActions button = GET_BUTTON.execute(pageObject, "Clear text");
        button.tap();
    }

    @JDIAction(value = "Perform tap on '{name}' Cancel button")
    public void tapCancelButton() {
        String cancelButtonLocator
                = getByLocator(core().getLocator()).concat("/../XCUIElementTypeButton[@name='Cancel']");
        $(cancelButtonLocator).tap();
    }
}
