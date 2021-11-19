package com.epam.jdi.light.material.asserts.utils;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matchers;

public class ModalAssert extends UIAssert<ModalAssert, Modal> {

    @JDIAction("Assert that {name} not visible")
    public ModalAssert notVisible() {
        jdiAssert(element().isVisible() ? "visible" : "not visible", Matchers.is("not visible"));
        return this;
    }

    @JDIAction("Assert that {name} has title")
    public ModalAssert title(String title) {
        jdiAssert(element().title(), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public ModalAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

}
