package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.AvatarAssert;

public class Avatar extends UIBaseElement<AvatarAssert> {
    @JDIAction("Is {name} displayed")
    @Override
    public boolean isDisplayed(){
        return core().isDisplayed();
    }

    @Override
    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }

    @JDIAction("Has {name} class {className}")
    public boolean hasClass(String className) {
        return core().hasClass(className);
    }

    @JDIAction("{name} has text {text}")
    public boolean hasText(String text){
        return core().getText().equals(text);
    }
}
