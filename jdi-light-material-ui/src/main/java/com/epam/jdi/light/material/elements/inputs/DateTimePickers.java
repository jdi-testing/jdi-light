package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.DateTimePickersAssert;

public class DateTimePickers  extends UIBaseElement<DateTimePickersAssert> {
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

    @Override
    public DateTimePickersAssert is() {
        return new DateTimePickersAssert().set(this);
    }
}
