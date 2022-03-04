package io.github.com.custom.elements.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;
import java.util.List;
import java.util.stream.Collectors;

public class VerticalStepper extends Stepper {

    @Override
    @JDIAction("Get '{name}' list of steps")
    public List<Step> steps() {
        return finds(steps).stream()
            .map(step -> new VerticalStep().setCore(VerticalStep.class, step))
            .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' step {0}")
    public VerticalStep step(int index) {
        return (VerticalStep) steps().get(index - 1);
    }
}
