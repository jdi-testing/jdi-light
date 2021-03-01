package com.epam.jdi.light.material.elements.utils;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIPopper;
import com.epam.jdi.light.material.asserts.utils.PopperAssert;

import java.lang.reflect.Field;

public class Popper extends UIBaseElement<PopperAssert> implements ISetup {

    String popper;
    String tooltip;

    @JDIAction("Popper is displayed")
    public boolean isPopperDisplayed(){
       return this.find(tooltip).isDisplayed();
    }

    @JDIAction("Popper is on the top")
    public String getPopperPosition(){
       return this.find(tooltip).getAttribute("x-placement");
    }

    @JDIAction("Get popper text")
    public String getPopperText(){
       return this.find(popper).getText();
    }

    @Override
    public PopperAssert is() {
        return new PopperAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIPopper.class, Popper.class))
            return;
        JDIPopper j = field.getAnnotation(JDIPopper.class);

        popper = j.popper();
        tooltip = j.tooltip();
    }
}
