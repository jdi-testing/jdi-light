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

/**
 * Desktop stepper MUI component representation on GUI. It contains several steps with some content and navigation buttons.
 *
 * @see Step
 * @see <a href="https://mui.com/components/steppers/">Stepper MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
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

    /**
     * Gets group of navigation buttons for this stepper.
     *
     * @return group of navigation buttons as {@link ButtonGroup}
     */
    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttonGroup() {
        //using class field caused problems at runtime, so create new instance by each method call
        return new ButtonGroup().setCore(ButtonGroup.class, UIFactory.$(buttonGroup));
    }

    /**
     * Gets step with given index counting from 1.
     *
     * @param index index of step to be searched
     * @return step with given index as {@link Step}
     */
    @JDIAction("Get '{name}' step {0}")
    public Step step(int index) {
        return steps().get(index - 1);
    }

    /**
     * Gets step with given label text (header).
     *
     * @param labelText text (header) of step to be searched
     * @return step with given label text as {@link Step}
     */
    @JDIAction("Get '{name}' step '{0}'")
    public Step step(String labelText) {
        return steps().stream()
                .filter(step -> step.labelText().equals(labelText))
                .findFirst()
                .orElseThrow(()-> Exceptions.runtimeException(String.format("No step '%s' found for stepper '%s'", labelText, this.getName())));
    }

    /**
     * Checks that step with given index exists in this stepper.
     *
     * @param index index of step to be searched
     * @return {@code true} if step with given index exists in this stepper, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has step with index {0}")
    public boolean hasStep(int index) {
        return index > 0 && index <= steps().size();
    }

    /**
     * Checks that step with given label text (header) exists in this stepper.
     *
     * @param labelText text (header) of step to be searched
     * @return {@code true} if step with given label text exists in this stepper, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has step with label text '{0}'")
    public boolean hasStep(String labelText) {
        return steps().stream().anyMatch(step -> step.labelText().equals(labelText));
    }

    /**
     * Checks that all steps in this stepper are completed.
     *
     * @return {@code true} all steps in this stepper are completed, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has all steps completed")
    public boolean hasAllStepsCompleted() {
        return steps().stream().allMatch(Step::isCompleted);
    }

    /**
     * Checks that all steps in this stepper are incomplete.
     *
     * @return {@code true} all steps in this stepper are incomplete, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has all steps incomplete")
    public boolean hasAllStepsIncomplete() {
        return steps().stream().noneMatch(Step::isCompleted);
    }

    @Override
    public DesktopStepperAssert is() {
        return new DesktopStepperAssert().set(this);
    }

    /**
     * Gets all steps of this stepper.
     *
     * @return all steps of this stepper as {@link List}
     */
    protected List<Step> steps() {
        return finds(".MuiStep-root").stream()
                .map(step -> new Step().setCore(Step.class, step))
                .collect(Collectors.toList());
    }
}
