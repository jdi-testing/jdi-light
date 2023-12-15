package com.epam.jdi.light.mobile.interfaces;

import com.epam.jdi.light.common.JDIAction;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface IViewControllersSwitch extends IMenu {
    @JDIAction(value = "Get '{name}' selected value")
    default String selected() {
        return core().get().findElements(AppiumBy.xpath("*")).stream()
                .filter(element -> element.getText().equals("1"))
                .findFirst()
                .get().getAttribute("name");
    }
}
