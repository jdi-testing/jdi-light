package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.DividerAssert;
import com.epam.jdi.light.vuetify.interfaces.IsVertical;

/**
 * To see an example of Divider web element please visit https://vuetifyjs.com/en/components/dividers/
 */

public class Divider extends UIBaseElement<DividerAssert> implements IsVertical {

    @Override
    public DividerAssert is() { return new DividerAssert().set(this); }

    public boolean isHorizontal(){
        return core().hasClass("v-divider--inset");
    }

    public boolean themeIsLight(){
        return core().hasClass("theme--light");
    }

    public boolean themeIsDark(){
        return core().hasClass("theme--dark");
    }
}
