package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules;
import com.epam.jdi.light.material.annotations.JStepper;

import java.lang.reflect.Field;

public abstract class Stepper<A extends UIAssert<?, ?>> extends UIBaseElement<A> implements ISetup {

    public abstract int currentIndex();

    public abstract int maxIndex();

    protected JStepper basicSetup(Field field) {
        if (FillFromAnnotationRules.fieldHasAnnotation(field, JStepper.class, Stepper.class)) {
            JStepper j = field.getAnnotation(JStepper.class);
            base().setLocator(WebDriverByUtils.NAME_TO_LOCATOR.execute(j.root()));
            return j;
        } else {
            return null;
        }
    }
}
