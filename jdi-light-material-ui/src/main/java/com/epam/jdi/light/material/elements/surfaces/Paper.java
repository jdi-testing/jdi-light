package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;

/**
 * To see an example of Paper web element please visit
 * https://jdi-docs.github.io/jdi-light/#paper
 */

public class Paper extends UIBaseElement<TextAssert> implements IsText, HasClick {

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
