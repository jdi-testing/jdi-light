package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.vuetify.enums.Themes.THEME_DARK;
import static com.epam.jdi.light.vuetify.enums.Themes.THEME_LIGHT;

public interface ThemeAssert<A, E extends HasTheme> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' has light theme")
    default A lightTheme() {
        jdiAssert(element().theme(), Matchers.is(THEME_LIGHT.getValue()), "Element has dark theme");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has dark theme")
    default A darkTheme() {
        jdiAssert(element().theme(), Matchers.is(THEME_DARK.getValue()), "Element has light theme");
        return (A) this;
    }
}
