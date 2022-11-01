package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ThemeAssert<A, E extends HasTheme> extends VuetifyElement<E> {

    @JDIAction("Assert that theme of '{name}' is light")
    default A lightTheme() {
        jdiAssert(element().theme(), Matchers.is("theme--light"), "Element has dark theme");
        return (A) this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    default A darkTheme() {
        jdiAssert(element().theme(), Matchers.is("theme--dark"), "Element has light theme");
        return (A) this;
    }
}
