package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIPicker;
import com.epam.jdi.light.material.asserts.inputs.DateTimePickersAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class DateTimePickers extends UIBaseElement<DateTimePickersAssert> implements ISetup {

    private String pickerInput;
    private String pickerLabel;
    private String pickerBtn;


    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIPicker.class, DateTimePickers.class))
            return;
        JDIPicker annotation = field.getAnnotation(JDIPicker.class);

        pickerInput = annotation.pickerInput();
        pickerLabel = annotation.pickerLabel();
        pickerBtn = annotation.pickerButton();
    }

    @Override
    public DateTimePickersAssert is() {
        return new DateTimePickersAssert().set(this);
    }

    @JDIAction("Get picker field with index {0}")
    public UIElement getPickerField(int index){
        return this.finds(pickerInput).get(index);
    }

    @JDIAction("Get picker calendar icon with index {0}")
    public UIElement getPickerBtn(int index){
        return this.finds(pickerBtn).get(index);
    }

    @JDIAction("Get picker title with index {0}")
    public UIElement getPickerLabel(int index){
        return this.finds(pickerLabel).get(index);
    }

    @JDIAction("Toggle '{name}'")
    public void toggle() {
        core().click();
    }

    @JDIAction("ToogleXY {name}")
    public void toogleXY(){
        core().click(3, 3);
    }

    @JDIAction("Set {name} value")
    public void setValue(String attr) {
        core().setText(attr);
    }

    @JDIAction("Get {name} value")
    public String getValue(){
        return core().getValue();
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Is {name} visible")
    public boolean isVisible(){
        return  core().isVisible();
    }

    @JDIAction("Value {name} contains")
    public boolean valueContains(String attr){
        return core().getValue().contains(attr);
    }
}
