package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.asserts.ViewControllersSwitchAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class ViewControllersSwitch extends MobileAppBaseElement<ViewControllersSwitchAssert> implements PageObject, HasTouchActions {
    private Object pageObject = this;

    public ViewControllersSwitch() {
        initElements(this);
    }

    @JDIAction(value = "Get '{name}' values")
    public List<String> values() {
        return core().get().findElements(By.xpath("*")).stream()
                .map(element -> element.getAttribute("name"))
                .collect(Collectors.toList());
    }

    @JDIAction(value = "Get '{name}' selected value")
    public String selected() {
        return core().get().findElements(By.xpath("*")).stream()
                .filter(element -> element.getText().equals("1"))
                .findFirst()
                .get().getAttribute("name");
    }

    @JDIAction(value = "Select '{name}' {0} value")
    public void select(String elementName) {
        HasTouchActions button = GET_BUTTON.execute(pageObject, elementName);
        button.tap();
    }

    @Override
    public ViewControllersSwitchAssert is() {
        return new ViewControllersSwitchAssert().set(this);
    }
}
