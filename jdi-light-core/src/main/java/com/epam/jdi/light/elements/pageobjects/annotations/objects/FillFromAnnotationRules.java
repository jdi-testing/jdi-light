package com.epam.jdi.light.elements.pageobjects.annotations.objects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.hasAnnotation;
import static com.jdiai.tools.ReflectionUtils.isInterface;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FillFromAnnotationRules {
    public static boolean fieldHasAnnotation(Field field, Class<? extends Annotation> annotationClass, Class<?> interfaceClass) {
        if (field == null) {
            return false;
        }
        boolean isAnnotation = hasAnnotation(field, annotationClass);
        return isAnnotation && isInterface(field, interfaceClass);
    }
}
