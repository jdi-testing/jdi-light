package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.PopperAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;

/**
 * To see an example of Popper web element please visit
 * https://mui.com/components/popper/
 */

public class Popper extends UIBaseElement<PopperAssert> implements IsText {

    @JDIAction("Get '{name}' position")
    public Position position() {
        return Position.fromString(core().attr("x-placement"));
    }

    @Override
    public PopperAssert is() {
        return new PopperAssert().set(this);
    }
}
