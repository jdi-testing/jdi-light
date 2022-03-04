package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.material.asserts.navigation.StepperWithProgressAssert;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import java.lang.reflect.Field;

public abstract class StepperWithProgress extends AbstractStepper<StepperWithProgressAssert> {

    public abstract int value();

    public abstract int maxValue();

    @Override
    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttonGroup() {
        return new ButtonGroup().setCore(ButtonGroup.class, this.core());
    }

    @Override
    public StepperWithProgressAssert is() {
        return new StepperWithProgressAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        super.setup(field);
    }
}
