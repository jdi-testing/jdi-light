package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Paper;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaperAssert extends UIAssert<PaperAssert, Paper> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public PaperAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
