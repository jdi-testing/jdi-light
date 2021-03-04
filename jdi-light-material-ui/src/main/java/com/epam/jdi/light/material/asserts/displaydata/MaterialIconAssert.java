package com.epam.jdi.light.material.asserts.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.MaterialIcon;
import org.hamcrest.Matchers;

public class MaterialIconAssert extends UIAssert<MaterialIconAssert, MaterialIcon> {

    @JDIAction("Assert that '{name}' is visible")
    @Override
    public MaterialIconAssert visible() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has correct size")
    public MaterialIconAssert checkSize(String size) {
        jdiAssert(element().isSize(size), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has correct color")
    public MaterialIconAssert checkColor(String color) {
        jdiAssert(element().isColor(color), Matchers.is(true));
        return this;
    }
}
