package com.epam.jdi.light.mobile.interfaces;

import com.epam.jdi.light.common.JDIAction;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public interface IMenu extends IMobileAppCoreElement{
    @JDIAction(value = "Get '{name}' values")
    default List<String> values() {
        return core().get().findElements(By.xpath("*")).stream()
                .map(element -> element.getAttribute("name"))
                .collect(Collectors.toList());
    }
}
