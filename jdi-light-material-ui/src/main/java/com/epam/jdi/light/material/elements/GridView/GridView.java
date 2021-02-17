package com.epam.jdi.light.material.elements.GridView;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIGridView;
import com.epam.jdi.light.material.asserts.gridView.GridViewAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class GridView extends UIBaseElement<GridViewAssert> implements ISetup {

    String root;
    String firstButton;

    @JDIAction("Is '{name}' enabled")
    public boolean isEnabled() {
        return core().hasClass(firstButton);
    }

    @JDIAction("Click on '{name}'")
    public void clickOn() {
        core().find(firstButton).click();
    }

    @Override
    public GridViewAssert is() {
        return new GridViewAssert().set(this);
    }

    @Override
    public void setup(Field f) {
        if (!fieldHasAnnotation(f, JDIGridView.class, GridView.class))
            return;
        JDIGridView j = f.getAnnotation(JDIGridView.class);
        root = j.root();
        firstButton = j.button();
    }
}
