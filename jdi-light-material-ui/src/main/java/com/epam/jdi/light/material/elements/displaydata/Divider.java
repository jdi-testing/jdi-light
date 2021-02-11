package com.epam.jdi.light.material.elements.displaydata;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIDivider;
import com.epam.jdi.light.material.asserts.displaydata.DividerAssert;

import java.lang.reflect.Field;

public class Divider extends UIBaseElement<DividerAssert> implements ISetup {

    String divider;

    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }

    public boolean isInset(){
        return this.find(divider).hasClass("MuiDivider-inset");
    }

    public boolean isVertical(){
        return this.find(divider).hasClass("MuiDivider-vertical");
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIDivider.class, Divider.class))
            return;
        JDIDivider j = field.getAnnotation(JDIDivider.class);
        divider =j.divider();
    }

}
