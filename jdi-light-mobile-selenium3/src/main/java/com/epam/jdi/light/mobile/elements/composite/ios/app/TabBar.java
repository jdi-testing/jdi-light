package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.asserts.ViewControllersSwitchAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import com.epam.jdi.light.mobile.interfaces.IViewControllersSwitch;

import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class TabBar extends MobileAppBaseElement<ViewControllersSwitchAssert> implements PageObject, HasTouchActions, IViewControllersSwitch {
    private Object pageObject = this;

    public TabBar() {
        initElements(this);
    }

    @JDIAction(value = "Perform tap on '{name}' {0} button")
    public void tapBarButton(String buttonName) {
        HasTouchActions button = GET_BUTTON.execute(pageObject, buttonName);
        button.tap();
    }

    @Override
    public ViewControllersSwitchAssert is() {
        return new ViewControllersSwitchAssert().set(this);
    }
}
