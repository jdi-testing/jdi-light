package com.epam.jdi.light.material.elements.navigation;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIStepper;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;
import java.lang.reflect.Field;



public class Stepper extends UIBaseElement<StepperAssert> implements ISetup {

    private String root;
    private String stepperButton;
    private String stepperTitle;

    private UIElement getButtonByIndex(int index) {
        return this.finds(stepperButton).get(index);
    }

    @JDIAction("Click on '{name}'")
    public void clickOnButtonByIndex(int index){
        getButtonByIndex(index).click();
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
        stepperButton = j.stepperNextButton();
    }
}
