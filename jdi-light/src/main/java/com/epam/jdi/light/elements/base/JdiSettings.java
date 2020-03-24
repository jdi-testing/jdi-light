package com.epam.jdi.light.elements.base;

import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JdiSettings {
    public static JFunc2<JDIBase, Object[], WebElement> GET_WITH_ARGS = (b, args) -> {
        if (b.webElement.hasValue()) {
            WebElement webElement = b.getCachedElement();
            if (webElement != null)
                return webElement;
        }
        if (b.locator.isEmpty())
            return b.beforeSearch(b.getSmart());
        if (b.locator.argsCount() != args.length)
            return b.getWebListFromArgs(args);
        List<WebElement> els = b.getAllElements(args);
        return b.getElement(els);
    };
}
