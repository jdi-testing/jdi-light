package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.CustomText;
import org.hamcrest.Matchers;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class CustomTextAssert extends UIAssert<CustomTextAssert, CustomText> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public CustomTextAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public CustomTextAssert color(Enum<?> color) {
        jdiAssert(element().css("color"), equalTo(color.toString()));
        return this;
    }

    @JDIAction("Assert that '{name}' has color '{0}'")
    public CustomTextAssert backgroundColor(Enum<?> color) {
        jdiAssert(element().css("background-color"), equalTo(color.toString()));
        return this;
    }
}
