package com.epam.jdi.light.vuetify.asserts.radiobuttons;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.radiobuttons.RadioButtons;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonsAssert extends UISelectAssert<RadioButtonsAssert, RadioButtons> implements
        ITextAssert<RadioButtonsAssert>, ThemeAssert<RadioButtonsAssert, RadioButtons>,
        ColorAssert<RadioButtonsAssert, RadioButtons>, ReadOnlyAssert<RadioButtonsAssert, RadioButtons>,
        DenseAssert<RadioButtonsAssert, RadioButtons>, MessagesAssert<RadioButtonsAssert, RadioButtons> {

    @JDIAction(value = "Assert that '{name}' label has color '{0}'")
    public RadioButtonsAssert labelColor(String color) {
        String actualColor = element().labelColor();
        jdiAssert(actualColor, Matchers.is(color),
                String.format("Actual label color of element is '%s', but expected '%s'", actualColor, color));
        return this;
    }
}
