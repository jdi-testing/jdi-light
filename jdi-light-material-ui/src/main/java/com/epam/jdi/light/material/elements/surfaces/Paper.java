package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;

/**
 * To see an example of Paper web element please visit
 * https://mui.com/components/paper/
 */

public class Paper extends UIBaseElement<PaperAssert> {

    @Override
    public PaperAssert is() {
        return new PaperAssert().set(this);
    }
}
