package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface HideDetailsAssert<A, E extends HasDetailsHidden> extends IBaseAssert<E> {
    @JDIAction("Assert that '{name}' has details hidden")
    default A detailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(true), "Element has not details hidden");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has not details hidden")
    default A notDetailsHidden() {
        jdiAssert(element().hasDetailsHidden(), Matchers.is(false), "Element has details hidden");
        return (A) this;
    }
}
