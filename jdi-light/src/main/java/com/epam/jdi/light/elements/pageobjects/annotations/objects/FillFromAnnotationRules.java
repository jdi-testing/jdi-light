package com.epam.jdi.light.elements.pageobjects.annotations.objects;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import java.lang.reflect.Field;

import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class FillFromAnnotationRules {

    public static boolean fieldHasAnnotation(Field field, Class annotationClass, Class interfaceClass) {
        boolean isAnnotation = field.isAnnotationPresent(annotationClass);
        return isAnnotation && isClass(field, interfaceClass);
    }
}
