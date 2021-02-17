package com.epam.jdi.light.material.asserts;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public abstract class CommonAssertMaterialUi<T extends CommonAssertMaterialUi<?, ?> ,A extends ICoreElement>
        extends UIAssert<T, A> {

    @JDIAction("Assert that '{name}' displayed")
    public IsAssert isMaterialUiElementDisplayed() {
       return core().classValue("-root");
    }

    @JDIAction("Assert that '{name}' disabled")
    public IsAssert isMaterialUiElementDisabled() {
        return core().classValue("Mui-disabled");
    }
}
