package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.material.asserts.navigation.StepperWithProgressAssert;
import java.lang.reflect.Field;

public abstract class StepperWithProgress extends AbstractStepper<StepperWithProgressAssert> {

    public abstract int value();

    public abstract int maxValue();

    @Override
    public StepperWithProgressAssert is() {
        return new StepperWithProgressAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        super.setup(field);
    }
}
