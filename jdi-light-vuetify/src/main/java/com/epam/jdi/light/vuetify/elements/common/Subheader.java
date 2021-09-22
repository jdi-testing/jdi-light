package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SubheaderAssert;

public class Subheader extends UIBaseElement<SubheaderAssert> implements IsText {

    @Override
    public SubheaderAssert is() {
        return new SubheaderAssert().set(this);
    }

    public boolean isInset(){
        return core().hasClass("v-subheader--inset");
    }

    public boolean themeIsLight(){
        return core().hasClass("theme--light");
    }

    public boolean themeIsDark(){
        return core().hasClass("theme--dark");
    }
}
