package com.jdiai.page.objects;

import com.jdiai.Section;
import com.jdiai.annotations.UI;
import com.jdiai.interfaces.HasCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.function.Function;

import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.jdiai.tools.JSTalkUtils.findByToBy;
import static com.jdiai.tools.JSTalkUtils.uiToBy;
import static com.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public class JDIPageFactory {
    public static boolean useSmartLocatorsWithoutUI = false;

    public static Function<Field, By> LOCATOR_FROM_FIELD = field -> {
        if (field.isAnnotationPresent(FindBy.class)) {
            FindBy findBy = field.getAnnotation(FindBy.class);
            return findByToBy(findBy);
        }
        if (field.isAnnotationPresent(UI.class)) {
            UI ui = field.getAnnotation(UI.class);
            By locator = uiToBy(ui);
            if (locator == null) {
                locator = SMART_LOCATOR.apply(field.getName());
            }
            return locator;
        }
        return useSmartLocatorsWithoutUI && !isClass(field, Section.class) && (isInterface(field, HasCore.class) || isInterface(field, WebElement.class))
            ? SMART_LOCATOR.apply(field.getName())
            : null;
    };
}
