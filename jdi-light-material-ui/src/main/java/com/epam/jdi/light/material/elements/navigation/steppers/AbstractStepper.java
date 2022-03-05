package com.epam.jdi.light.material.elements.navigation.steppers;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import java.lang.reflect.Field;

public abstract class AbstractStepper<A extends UIAssert<?, ?>> extends UIBaseElement<A>
    implements ISetup {

    protected String root;
    protected String buttonGroup;

    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttonGroup() {
        return new ButtonGroup().setCore(ButtonGroup.class, $(buttonGroup));
    }

    @Override
    public A is() {
        return (A) new UIAssert<>().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JStepper.class, AbstractStepper.class)) {
            return;
        }
        JStepper j = field.getAnnotation(JStepper.class);
        root = j.root();
        buttonGroup = j.buttonGroup();
        base().setLocator(NAME_TO_LOCATOR.execute(root));
    }
}
