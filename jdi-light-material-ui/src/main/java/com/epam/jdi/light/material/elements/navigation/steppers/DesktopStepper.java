package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.asserts.navigation.DesktopStepperAssert;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class DesktopStepper extends Stepper<DesktopStepperAssert> {

    private String buttonGroup;

    @Override
    public void setup(Field field) {
        JStepper j = basicSetup(field);
        if (j != null) {
            buttonGroup = j.buttonGroup();
        }
    }

    @Override
    @JDIAction("Get '{name}' current step index")
    public int currentIndex() {
        Step currentStep = steps().stream()
                .filter(step -> step.isEnabled() && !step.isCompleted())
                .findFirst()
                .orElseThrow(()-> Exceptions.runtimeException(String.format("No active steps found for stepper '%s'", this.getName())));
        return steps().indexOf(currentStep) + 1;
    }

    @Override
    @JDIAction("Get '{name}' max step index")
    public int maxIndex() {
        return steps().size();
    }

    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttonGroup() {
        //using class field caused problems at runtime, so create new instance by each method call
        return new ButtonGroup().setCore(ButtonGroup.class, UIFactory.$(buttonGroup));
    }

    @JDIAction("Get '{name}' step {0}")
    public Step step(int index) {
        return steps().get(index - 1);
    }

    @JDIAction("Get '{name}' step '{0}'")
    public Step step(String labelText) {
        return steps().stream()
                .filter(step -> step.labelText().equals(labelText))
                .findFirst()
                .orElseThrow(()-> Exceptions.runtimeException(String.format("No step '%s' found for stepper '%s'", labelText, this.getName())));
    }

    @JDIAction("Check that '{name}' has step with index {0}")
    public boolean hasStep(int index) {
        return index > 0 && index <= steps().size();
    }

    @JDIAction("Check that '{name}' has step with label text '{0}'")
    public boolean hasStep(String labelText) {
        return steps().stream().anyMatch(step -> step.labelText().equals(labelText));
    }

    @JDIAction("Check that '{name}' has all steps completed")
    public boolean hasAllStepsCompleted() {
        return steps().stream().allMatch(Step::isCompleted);
    }

    @JDIAction("Check that '{name}' has all steps incomplete")
    public boolean hasAllStepsIncomplete() {
        return steps().stream().noneMatch(Step::isCompleted);
    }

    @Override
    public DesktopStepperAssert is() {
        return new DesktopStepperAssert().set(this);
    }

    private List<Step> steps() {
        return finds(".MuiStep-root").stream()
                .map(step -> new Step().setCore(Step.class, step))
                .collect(Collectors.toList());
    }
}
