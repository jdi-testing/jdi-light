package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TextStyledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevatedAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AlertAssert extends UIAssert<AlertAssert, Alert> implements ITextAssert<AlertAssert>,
        DenseAssert<AlertAssert, Alert>, ColorAssert<AlertAssert, Alert>,
        MeasurementAssert<AlertAssert, Alert>, ThemeAssert<AlertAssert, Alert>,
        TileAssert<AlertAssert, Alert>, TextStyledAssert<AlertAssert, Alert>,
        ShapedAssert<AlertAssert, Alert>, RoundedAssert<AlertAssert, Alert>,
        OutlinedAssert<AlertAssert, Alert>, ElevatedAssert<AlertAssert, Alert> {


    @JDIAction("Assert that '{name}' text {0}")
    public AlertAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    public AlertAssert text(String text) {
        return text(Matchers.is(text));
    }
}
