package com.epam.jdi.light.elements.base;

import com.jdiai.tools.func.JFunc2;
import org.openqa.selenium.WebElement;

public class SeleniumSettings {
    public static JFunc2<JDIBase, Object[], WebElement> GET_WITH_ARGS =
            (b, args) -> b.driver().findElement(b.getLocator(args));
    public static JFunc2<JDIBase, Object[], WebElement> GET_AND_VALIDATE = GET_WITH_ARGS;
}
