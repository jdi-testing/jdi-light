package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIPicker;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;
import com.epam.jdi.light.material.asserts.inputs.PickersAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Picker extends UIBaseElement<PickersAssert> implements ISetup {
    private String pickerField;
    private String pickerRoot;
    private String pickerIcon;


    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIPicker.class, Picker.class))
            return;
        JDIPicker annotation = field.getAnnotation(JDIPicker.class);

        pickerField = annotation.pickerField();
        pickerRoot = annotation.pickerRoot();
        pickerIcon = annotation.pickerCalendarButton();
    }

    @JDIAction("Get picker field with index {0}")
    public UIElement getPickerField(int index){
        return this.finds(pickerField).get(index);
    }

    @Override
    public PickersAssert is() {
        return new PickersAssert().set(this);
    }
}
