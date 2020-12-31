package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.asserts.ViewControllersSwitchAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import com.epam.jdi.light.mobile.interfaces.IViewControllersSwitch;

import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class SegmentedControl extends MobileAppBaseElement<ViewControllersSwitchAssert> implements PageObject, HasTouchActions, IViewControllersSwitch {
    private Object pageObject = this;

    public SegmentedControl() {
        initElements(this);
    }

    @JDIAction(value = "Perform tap on '{name}' {0} segment")
    public void tapSegment(String segmentName) {
        HasTouchActions button = GET_BUTTON.execute(pageObject, segmentName);
        button.tap();
    }

    @Override
    public ViewControllersSwitchAssert is() {
        return new ViewControllersSwitchAssert().set(this);
    }
}
