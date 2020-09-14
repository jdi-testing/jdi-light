package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends UIBaseElement<TextAssert>
        implements IsText {
    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
