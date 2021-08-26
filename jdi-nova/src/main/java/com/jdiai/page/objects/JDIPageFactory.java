package com.jdiai.page.objects;

import com.jdiai.Section;
import com.jdiai.annotations.UI;
import com.jdiai.interfaces.HasCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.function.Function;

import static com.jdiai.tools.JSUtils.findByToBy;
import static com.jdiai.tools.JSUtils.uiToBy;
import static com.jdiai.tools.ReflectionUtils.isClass;
import static com.jdiai.tools.ReflectionUtils.isInterface;
import static com.jdiai.tools.TestIDLocators.SMART_LOCATOR;

public class JDIPageFactory {
    public static boolean useSmartLocatorsWithoutUI = false;

    public static By defaultLocatorFromField(Field field) {
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
        UI classUI = getClassAnnotation(field.getType(), UI.class);
        if (classUI != null) {
            return uiToBy(classUI);
        }
        return useSmartLocatorsWithoutUI && !isClass(field, Section.class) && (isInterface(field, HasCore.class) || isInterface(field, WebElement.class))
                ? SMART_LOCATOR.apply(field.getName())
                : null;
    }

    static <T extends Annotation> T getClassAnnotation(Class<?> cl, Class<T> annotation) {
        while (cl != null && cl != Object.class) {
            if (cl.isAnnotationPresent(annotation)) {
                return cl.getAnnotation(annotation);
            }
            cl = cl.getSuperclass();
        }
        return null;
    }

    public static Function<Field, By> LOCATOR_FROM_FIELD = JDIPageFactory::defaultLocatorFromField;
}
