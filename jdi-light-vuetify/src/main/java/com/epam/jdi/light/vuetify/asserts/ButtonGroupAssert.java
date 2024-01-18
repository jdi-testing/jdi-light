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
    @JDIAction(value = "Assert that {0} button is selected in {name}", isAssert = true)
    public ButtonGroupAssert selected(int index) {
        jdiAssert(element().selected(index), Matchers.is(true),
                String.format("Button with number %d is not selected", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size {0}", isAssert = true)
    public ButtonGroupAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public ButtonGroupAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "ButtonGoup does not have icon");
        return this;
    }

}
