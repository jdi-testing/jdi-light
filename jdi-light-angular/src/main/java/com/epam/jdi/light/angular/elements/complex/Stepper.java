package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.StepperAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

import java.util.List;

public class Stepper extends UIBaseElement<StepperAssert> {

    public String headerLocator = "//div[contains(@class,'mat-horizontal-stepper-header-container')]";
    public String contentLocator = "//div[contains(@class,'mat-horizontal-content-container')]";
    public String stepsLocator = headerLocator.concat("//mat-step-header");
    public String stepLocator = stepsLocator.concat("[@aria-posinset='%s']");
    public String activeStepLocator = stepsLocator.concat("[@tabindex='0']");
    public String textInput = contentLocator.concat("//div[@aria-expanded='true']//input");
    public String nextButtonLocator = contentLocator.concat("//div[@aria-expanded='true']//button[@matsteppernext='']");
    public String previousButtonLocator = contentLocator.concat("//div[@aria-expanded='true']//button[@matstepperprevious='']");
    public String resetButtonLocator = contentLocator.concat("//div[@aria-expanded='true']//span[text()='Reset']/..");

    public String getActiveStep() {
        return this.uiElement.find(By.xpath(activeStepLocator)).getAttribute("aria-posinset");
    }

    @JDIAction("Is '{name}' stepper at step '{0}'")
    public boolean isAtStep(String value) {
        return getActiveStep().equals(value);
    }

    public void gotoStep(String value) {
        this.uiElement.find(By.xpath(String.format(stepLocator, value))).click();
    }

    public void clickNextButton() {
        this.uiElement.find(By.xpath(nextButtonLocator)).click();
    }

    public void clickPreviousButton() {
        this.uiElement.find(By.xpath(previousButtonLocator)).click();
    }

    public void clickResetButton() {
        this.uiElement.find(By.xpath(resetButtonLocator)).click();
    }

    public void input(String value) {
        UIElement input = this.uiElement.find(By.xpath(textInput));
        input.clear();
        input.input(value);
    }


    public List<UIElement> getSteps() {
        return this.uiElement.finds(By.xpath(stepsLocator));
    }



    @JDIAction("Get '{name}' '{0}' value")
    public String value(final String field) {
        return "";
    }

    @Override
    public StepperAssert is() { return new StepperAssert().set(this); }
}
