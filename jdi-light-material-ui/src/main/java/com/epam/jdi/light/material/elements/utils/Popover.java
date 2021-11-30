package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.PopoverAssert;

/**
 * To see an example of Popover web element please visit
 * https://mui.com/components/popover/
 */

public class Popover extends UIBaseElement<PopoverAssert> implements IsText {

    public UIElement button(String text) {
        return $("//span[contains(text(), '" + text + "')]");
    }

    @Override
    public PopoverAssert is() {
        return new PopoverAssert().set(this);
    }
}
