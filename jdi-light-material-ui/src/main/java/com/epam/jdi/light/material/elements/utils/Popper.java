package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.PopperAssert;

/**
 * To see an example of Popper web element please visit
 * https://mui.com/components/popper/
 */

public class Popper extends UIBaseElement<PopperAssert> implements IsText {

    public UIElement popperButton(String name) {
        return $("//span[contains(text(), '" + name + "')]");
    }

    @JDIAction("Check {name} position")
    public String position() {
        return core().attr("x-placement");
    }

    @Override
    public PopperAssert is() {
        return new PopperAssert().set(this);
    }
}
