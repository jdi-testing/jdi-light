package com.epam.jdi.light.material.elements.navigation;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIStepper;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;
import java.lang.reflect.Field;



public class Stepper extends UIBaseElement<StepperAssert> implements ISetup {

    private String root;
    private String stepperNextButton;
    private String stepperBackButton;
    private String stepperFinishButton;
    private String stepperResetButton;
    private String stepperSkipButton;
    private String stepperCompleteStepButton;
    private String stepperTitle;

    @JDIAction("Click on '{name}'")
    public void clickNextButton(){
        this.find(stepperNextButton).click();
    }

    @JDIAction("Click on '{name}'")
    public void clickBackButton(){
        this.find(stepperBackButton).click();
    }

    @JDIAction("Click on '{name}'")
    public void clickFinishButton(){
        this.find(stepperFinishButton).click();
    }

    @JDIAction("Click on '{name}'")
    public void clickResetButton(){
        this.find(stepperResetButton).click();
    }

    @JDIAction("Click on '{name}'")
    public void clickSkipButton(){
        this.find(stepperSkipButton).click();
    }

    @JDIAction("Click on '{name}'")
    public void clickCompleteStepButton(){
        this.find(stepperCompleteStepButton).click();
    }

    @JDIAction("Get '{name}'")
    public String getStepTitle(){
        return this.find(stepperTitle).getText();
    }

    @JDIAction("Is '{name}' correct")
    public boolean isTitleCorrect(String title){
        return title.equals(getStepTitle());
    }

    @JDIAction("Is '{name}' displayed")
    public boolean isStepperDisplayed(){
        return this.find(root).isDisplayed();
    }

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIStepper.class, Stepper.class))
            return;
        JDIStepper j = field.getAnnotation(JDIStepper.class);

        root = j.root();
        stepperTitle = j.stepperTitle();
        stepperNextButton = j.stepperNextButton();
        stepperBackButton = j.stepperBackButton();
        stepperFinishButton = j.stepperFinishButton();
        stepperResetButton = j.stepperResetButton();
        stepperSkipButton = j.stepperSkipButton();
        stepperCompleteStepButton = j.stepperCompleteStepButton();
    }
}
