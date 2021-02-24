package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDITransition;
import com.epam.jdi.light.material.asserts.utils.TransitionAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Transition extends UIBaseElement<TransitionAssert> implements ISetup {

    String switchBase;
    String paper;

    @JDIAction("Click switch in '{name}'")
    public void clickSwitch() {
        core().find(switchBase).click();
    }

    @JDIAction("Get content of '{name}'")
    public String getContent() {
        return core().find(paper).getText();
    }

    @Override
    public boolean isVisible() {
        return "visible".equalsIgnoreCase(core().find(paper).getCssValue("visibility"));
    }

    @Override
    public boolean isHidden() {
        return "hidden".equalsIgnoreCase(core().find(paper).getCssValue("visibility"));
    }

    @Override
    public TransitionAssert is() {
        return new TransitionAssert().set(this);
    }

    @Override
    public TransitionAssert has() {
        return this.is();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITransition.class, Transition.class))
            return;
        JDITransition j = field.getAnnotation(JDITransition.class);
        switchBase = j.switchBase();
        paper = j.expandedElement();
    }
}
