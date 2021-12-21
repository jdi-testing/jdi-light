package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

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
