package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.StepperAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

import java.util.List;

public class Stepper extends UIBaseElement<StepperAssert> {

    public String headerLocator = "//div[contains(@class,'mat-horizontal-stepper-header-container')]";
    public String contentLocator = "//div[contains(@class,'mat-horizontal-content-container')]";
    public String stepsLocator = headerLocator.concat("//mat-step-header");

    public List<UIElement> getSteps() {
        return this.uiElement.finds(By.xpath(stepsLocator));
    }

    @JDIAction("Get '{name}' '{0}' value")
    public String value(final String field) {
        return "";
    }
}
