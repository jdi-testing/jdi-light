package com.epam.jdi.light.elements.base;

import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class JdiSettings {
    public static JFunc2<JDIBase, Object[], WebElement> GET_WITH_ARGS = (b, args) -> {
        logger.debug("GET_WITH_ARGS");
        if (b.webElement.hasValue()) {
            WebElement webElement = null;
            try {
                webElement = b.getCachedElement();
            } catch (Exception ignore) { }
            if (webElement != null)
                return webElement;
        }
        if (b.locator.isNull())
            return b.beforeSearch(b.getSmart());
        if (b.locator.argsCount() != args.length)
            return b.getUIElementFromArgs(args);
        List<WebElement> els = b.getAllElementsInContext(args);
        return b.getElement(els);
    };
}
