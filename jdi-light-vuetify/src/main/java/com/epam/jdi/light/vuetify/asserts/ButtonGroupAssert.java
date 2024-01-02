package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ButtonGroup;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matchers;

public class ButtonGroupAssert extends UISelectAssert<ButtonGroupAssert, ButtonGroup>
    implements ThemeAssert<ButtonGroupAssert, ButtonGroup>, ColorAssert<ButtonGroupAssert, ButtonGroup>,
    RoundedAssert<ButtonGroupAssert, ButtonGroup>, ShapedAssert<ButtonGroupAssert, ButtonGroup>,
    DenseAssert<ButtonGroupAssert, ButtonGroup>, MeasurementAssert<ButtonGroupAssert, ButtonGroup>,
    TileAssert<ButtonGroupAssert, ButtonGroup> {

    @Override
    @JDIAction(value = "Assert that {0} item is selected in {name}")
    public ButtonGroupAssert selected(int index) {
        jdiAssert(element().selected(index) ? "is selected" : "is not selected",
            Matchers.is("is selected"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size {0}")
    public ButtonGroupAssert size(int size) {
        int actualSize = element().size();
        jdiAssert(actualSize, Matchers.is(size), String.format("Actual size '%s' is not equal to expected '%s'",
            actualSize, size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon")
    public ButtonGroupAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element does not have icon");
        return this;
    }

}
