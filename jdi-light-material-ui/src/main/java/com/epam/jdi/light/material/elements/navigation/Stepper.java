package com.epam.jdi.light.material.elements.navigation;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

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

    public void clickNextButton(){
        this.find(stepperNextButton).click();
    }

    public void clickBackButton(){
        this.find(stepperBackButton).click();
    }

    public void clickFinishButton(){
        this.find(stepperFinishButton).click();
    }

    public void clickResetButton(){
        this.find(stepperResetButton).click();
    }

    public void clickSkipButton(){
        this.find(stepperSkipButton).click();
    }

    public void clickCompleteStepButton(){
        this.find(stepperCompleteStepButton).click();
    }

    private String getStepTitle(){
        return this.find(stepperTitle).getText();
    }

    public boolean isTitleCorrect(String title){
        return title.equals(getStepTitle());
    }

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
