package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIChip;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;

import java.lang.reflect.Field;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Chip extends UIBaseElement<ChipAssert> implements ISetup {
    private String chipLabel;
    private String chipRoot;
    private String chipIcon;

    @JDIAction("Click {name}")
    public void click(int index){
        this.getChipLabel(index).click();
    }

    @JDIAction("Get chip label with index {0}")
    public UIElement getChipLabel(int index){
        return this.finds(chipLabel).get(index);
    }

    @JDIAction("Get chip root with index {0}")
    public UIElement getChipRoot(int index){
        return this.finds(chipRoot).get(index);
    }

    @JDIAction("Get chip icon with index {0}")
    public UIElement getChipIcon(int index){
        return this.finds(chipIcon).get(index);
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIChip.class, Chip.class))
            return;
        JDIChip j = field.getAnnotation(JDIChip.class);

        chipLabel = j.chipLabel();
        chipRoot = j.chipRoot();
        chipIcon = j.chipIcon();
    }
}
