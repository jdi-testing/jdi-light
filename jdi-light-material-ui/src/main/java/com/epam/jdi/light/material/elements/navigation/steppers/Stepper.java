package com.epam.jdi.light.material.elements.navigation.steppers;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Stepper web element please visit
 * https://mui.com/components/steppers/
 */

public class Stepper extends AbstractStepper<StepperAssert> {

    protected String steps = ".MuiStep-root";

    @JDIAction("Get list of steps in {name}")
    public List<Step> steps() {
        return finds(steps).stream()
            .map(step -> new Step().setCore(Step.class, step))
            .collect(Collectors.toList());
    }

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        super.setup(field);
        if (fieldHasAnnotation(field, JStepper.class, Stepper.class)) {
            steps = field.getAnnotation(JStepper.class).steps();
        }
    }
}
