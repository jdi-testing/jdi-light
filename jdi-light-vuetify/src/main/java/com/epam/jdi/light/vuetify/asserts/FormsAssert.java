package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.elements.composite.Forms;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FormsAssert extends TextAssert {

    public FormsAssert validate() {
        jdiAssert(element().validate(), Matchers.is(true));
        return this;
    }

    @Override
    public Forms element() {
        return (Forms) super.element();
    }
}
